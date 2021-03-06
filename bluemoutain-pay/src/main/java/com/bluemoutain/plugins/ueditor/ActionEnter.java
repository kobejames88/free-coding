package com.bluemoutain.plugins.ueditor;



import com.bluemoutain.plugins.FileManagerUpload;
import com.bluemoutain.plugins.fastdfs.FastDfsUtil;
import com.bluemoutain.plugins.ueditor.define.ActionMap;
import com.bluemoutain.plugins.ueditor.define.AppInfo;
import com.bluemoutain.plugins.ueditor.define.BaseState;
import com.bluemoutain.plugins.ueditor.define.State;
import com.bluemoutain.plugins.ueditor.hunter.FileManager;
import com.bluemoutain.plugins.ueditor.hunter.ImageHunter;
import com.bluemoutain.plugins.ueditor.upload.Uploader;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ActionEnter {

    private FastDfsUtil fastDfsUtil = null;

    private HttpServletRequest request = null;

    private String rootPath = null;

    private String contextPath = null;

    private String actionType = null;

    private ConfigManager configManager = null;

    private Integer storage_type;

    private FileManagerUpload fileManager;

    public ActionEnter(HttpServletRequest request, FastDfsUtil util, String rootPath, Integer type, FileManagerUpload manager) {
        this.fastDfsUtil = util;
        this.request = request;
        this.rootPath = rootPath;
        this.actionType = request.getParameter("action");
        this.contextPath = request.getContextPath();
        this.storage_type = type;
        this.fileManager = manager;
        this.configManager = ConfigManager.getInstance(this.rootPath, this.contextPath, request.getRequestURI());
    }

    public String exec() throws Exception {
        String callbackName = this.request.getParameter("callback");
        if (callbackName != null) {
            if (!validCallbackName(callbackName)) {
                return new BaseState(false, AppInfo.ILLEGAL).toJSONString();
            }
            return callbackName + "(" + this.invoke() + ");";
        } else {
            return this.invoke();
        }
    }

    public String invoke() throws Exception {
        if (actionType == null || !ActionMap.mapping.containsKey(actionType)) {
            return new BaseState(false, AppInfo.INVALID_ACTION).toJSONString();
        }
        if (this.configManager == null || !this.configManager.valid()) {
            return new BaseState(false, AppInfo.CONFIG_ERROR).toJSONString();
        }
        State state = null;
        int actionCode = ActionMap.getType(this.actionType);
        Map<String, Object> conf = null;
        switch (actionCode) {
            case ActionMap.CONFIG:
                return this.configManager.getAllConfig().toString();
            case ActionMap.UPLOAD_IMAGE:
            case ActionMap.UPLOAD_SCRAWL:
            case ActionMap.UPLOAD_VIDEO:
            case ActionMap.UPLOAD_FILE:
                conf = this.configManager.getConfig(actionCode);
                state = new Uploader(request, conf, fastDfsUtil,storage_type,fileManager).doExec();
                break;
            case ActionMap.CATCH_IMAGE:
                conf = configManager.getConfig(actionCode);
                String[] list = this.request.getParameterValues((String) conf.get("fieldName"));
                state = new ImageHunter(conf).capture(list);
                break;
            case ActionMap.LIST_IMAGE:
            case ActionMap.LIST_FILE:
                conf = configManager.getConfig(actionCode);
                int start = this.getStartIndex();
                state = new FileManager(conf).listFile(start);
                break;
        }
        return state.toJSONString();
    }

    public int getStartIndex() {

        String start = this.request.getParameter("start");

        try {
            return Integer.parseInt(start);
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * callback参数验证
     */
    public boolean validCallbackName(String name) {
        return name.matches("^[a-zA-Z_]+[\\w0-9_]*$");

    }

}