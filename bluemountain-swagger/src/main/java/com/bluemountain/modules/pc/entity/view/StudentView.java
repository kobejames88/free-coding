package modules.pc.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import modules.pc.entity.StudentEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 14:56:33
 */
@TableName("t_student")
@ApiModel(value = "Student")
public class StudentView  extends StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public StudentView(){
	}
 
 	public StudentView(StudentEntity studentEntity){
 	try {
			BeanUtils.copyProperties(this, studentEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
