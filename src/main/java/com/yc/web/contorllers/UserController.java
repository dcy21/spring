package com.yc.web.contorllers;

import com.sun.deploy.net.HttpResponse;
import com.yc.beans.JsonModel;
import com.yc.beans.User;
import com.yc.beans.JsonModel;
import com.yc.beans.User;
import com.yc.biz.UserBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Api(value ="/user",tags ="用户模块")
@Controller//类注解 同时使用@Cotroller 和@ResponseBody
public class UserController {
    @Resource(name ="userBizImpl")
    private UserBiz userBiz;
   @PostMapping("/user_register.action")
    public JsonModel register(User user){
        JsonModel jm=new JsonModel();
        boolean result=userBiz.register(user);
       if (result) {
           jm.setCode(1);
       }else {
           jm.setCode(0);
       }
       return jm;

    }

   //因为登陆后是要直接到list.jsp页面做显示，且login.jsp页是通过submit提交的
    //既不支持ajax，不用回送json数据，而应回送是一个页面的名字，这样springmvc的视图解析器就可以运行了
   @ApiOperation(value ="用户登录",notes ="用户登录")
   @ApiImplicitParam(name ="user",value = "User",required =true,dataType = "User")
   @PostMapping("/user_login.action")
   public ModelAndView login(User user, HttpServletRequest request, HttpSession session){
       //为什么有三个参数？因为name password是user对象中有的，但zccode是类中没有的，所以要通过request取
       //另外rand是存在session中的，所以要HttpSession
       ModelAndView mav=new ModelAndView();
       String zccode=request.getParameter("zccode");
       String rand=session.getAttribute("sRand").toString();
       if (!rand.equals(zccode)) {
           request.setAttribute("errormsg","验证码错误");
       } else {
           user=userBiz.login(user);
            if(user!=null){
                session.setAttribute("user",user);
                mav.setViewName("list");
                return mav;
            }else {
                request.setAttribute("errormsg","用户名或密码错误");
            }

       }
       mav.setViewName("login");
       return mav;

   }
}
