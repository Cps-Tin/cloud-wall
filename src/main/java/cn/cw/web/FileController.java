package cn.cw.web;

import cn.cw.core.Result;
import cn.cw.core.ResultGenerator;
import cn.cw.util.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * 文件管理
 */
@Controller
@ResponseBody
@RequestMapping("/file")
public class FileController {

	@Value("${web.upload-path}")
	private String upLoadPath;

	//如果不启用WebMvcConfigurer，不给类添加RequestMapping("/user")的话,下面就是配置默认访问页面
	//	@GetMapping({"/", "/login.html"})
	//	public String index(Model model) {
	//		//重定向到 getUserList 请求
	//		return "login";
	//	}

	/**
	 * 上传图片
	 * @param request
	 */
	@RequestMapping(value = "/upLoadImg")
	public Result upLoad(HttpServletRequest request) {
		String dirPath = request.getSession().getServletContext().getRealPath(upLoadPath);
		Result result = FileUtil.upLoadFile(upLoadPath,dirPath,request);
		// 去更新用户的头像信息
		result.getMessage();
		return result;
	}

	/**
	 * 文件下载
	 * @param fileName
	 */
	@RequestMapping("/downLoadFile")
	public Result downLoadFile(String fileName,HttpServletRequest request, HttpServletResponse response) {
		String dirPath = request.getSession().getServletContext().getRealPath(upLoadPath);
		return FileUtil.downLoadFile(fileName,dirPath,response);
	}

	/**
	 * 删除服务器文件
	 * @param fileName
	 * @return
	 */
	@RequestMapping("/revomeFile")
	public Result revomeFile(String fileName,HttpServletRequest request){
		String dirPath = request.getSession().getServletContext().getRealPath(upLoadPath);
		return ResultGenerator.genSuccessResult(FileUtil.removeFile(fileName,dirPath));
	}

}
