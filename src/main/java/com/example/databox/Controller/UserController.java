package com.example.databox.Controller;

import com.example.databox.Entity.CollectionsInfo;
import com.example.databox.Entity.LogInfo;
import com.example.databox.Entity.UserInfo;
import com.example.databox.Mapper.CollectionsMapper;
import com.example.databox.Mapper.LogMapper;
import com.example.databox.Mapper.UserMapper;
import com.example.databox.Util.FileUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private CollectionsMapper collectionsMapper;

    /**
     *
     * @param pageIndex 用户管理分页页面
     * @param pageSize 分页每页的数据
     * @param UserName 获取用户名
     * @param UserPhone 获取密码
     * @param model 使用的模型
     * @return 该路径下返回useradmin页面
     */
    @RequestMapping("/useradmin")
    public String getUserByNameByPhone(@RequestParam (value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                       @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                       @RequestParam(value = "UserName",defaultValue = "") String UserName,
                                       @RequestParam(value = "UserPhone",defaultValue = "") String UserPhone,Model model){
        PageHelper.startPage(pageIndex, pageSize);
        List<UserInfo> lists = null;
        PageInfo<UserInfo> listInfo=null;
        if (UserName.isEmpty()&&UserPhone.isEmpty()){
            lists = userMapper.getAllUser(pageIndex,pageSize);
        }else if (UserName.isEmpty()&&!UserPhone.isEmpty()){
            lists = userMapper.getUserByUserPhone(pageIndex,pageSize,UserPhone);
        }else {
            lists = userMapper.getUserByUserNameUserPhone(pageIndex,pageSize,UserName,UserPhone);
        }
        PageInfo<UserInfo> pages=new PageInfo<>(lists);
        List<UserInfo> UserInfoList=userMapper.getAllUser(pageIndex,pageSize);
        model.addAttribute("UserName",UserName);
        model.addAttribute("UserPhone",UserPhone);
        model.addAttribute("userInfo",UserInfoList);
        model.addAttribute("User",pages);
        return "useradmin";
    }

    @GetMapping("/login")
    public String UserLogin(){
        return "login";
    }

    /**
     *
     * @param UserPhone 获取用户电话
     * @param Password 获取用户密码
     * @param session 将用户电话和密码封装到sessio里
     * @param logInfo 获取loginfo表
     * @param request 用户登录日志
     * @param response 用户登录日志
     * @return 返回login页面
     */
    @PostMapping("/login")
    @ResponseBody()
    public String UserLogin(@RequestParam("UserPhone") String UserPhone,
                            @RequestParam("Password") String Password,
                            HttpSession session, LogInfo logInfo,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "127.0.0.1";
        }
        System.out.println("IP地址：" + ip);
        String agentStr = request.getHeader("user-agent");
        System.out.println(agentStr);
        UserAgent agent = UserAgent.parseUserAgentString(agentStr);
        //浏览器
        Browser browser = agent.getBrowser();
        System.out.println("名称：" + browser.getName());
        //操作系统
        System.out.println("========================");
        OperatingSystem os = agent.getOperatingSystem();
        System.out.println("名称：" + os.getName());
        Integer UserID = agent.getId();
        System.out.println("用户编号：" + UserID);
        logInfo.setIE(browser.getName().toString());
        logInfo.setIP_Address(ip.toString());
        logInfo.setOS(os.getName().toString());
        UserInfo userInfo = userMapper.userLogin(UserPhone,Password);
        if (userInfo != null) {
            session.setAttribute("UserInfo", userInfo);
            logInfo.setUserID(userInfo.getUserID());
            logInfo.setUserName(userInfo.getUserName());

            int i = logMapper.addLog(logInfo);

            return "1";
        } else {
            return "0";
        }
    }
    /**
     *
     * @param pageIndex
     * @param pageSize
     * @param UserName 获取用户名
     * @param CreatDate 获取时间
     * @param model
     * @return
     */
    @RequestMapping("/log")
    public String getUserByNameByPhone(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                       @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                       @RequestParam(value = "UserName",defaultValue = "") String UserName,
                                       @RequestParam(value = "CreatDate",defaultValue = "") Date CreatDate, Model model) {
        PageHelper.startPage(pageIndex, pageSize);
        List<LogInfo> lists = null;
        PageInfo<LogInfo> listInfo = null;
        if (UserName.isEmpty() && CreatDate == null) {
            lists = logMapper.getAllLog(pageIndex, pageSize);
        } else if (!UserName.isEmpty() && CreatDate==null) {
            lists = logMapper.getLogByName(pageIndex, pageSize, UserName);
        } else {
            lists = logMapper.getLogByDateName(pageIndex, pageSize, CreatDate, UserName);
        }
        PageInfo<LogInfo> pages = new PageInfo<>(lists);
        List<LogInfo> LogInfoList = logMapper.getAllLog(pageIndex, pageSize);
        model.addAttribute("UserName", UserName);
        model.addAttribute("CreatDate", CreatDate);
        model.addAttribute("LogInfo", LogInfoList);
        model.addAttribute("log", pages);
        return "log";
    }




    @GetMapping("/blank")
    public String blankPage(){
        return "blank";
    }

    @GetMapping("/position1")
    public String position1Page() {
        return "position1";
    }

    @GetMapping("/position2")
    public String position2Page() {
        return "position2";
    }
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/adduser")
    public String addUserInfo() {
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUserInfo(UserInfo userInfo, @RequestParam("filepic")MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUpLoadFilePath();
        fileName = System.currentTimeMillis()+fileName;
        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userInfo.setUser_image_url(fileName);
        int i = userMapper.saveUserInfo(userInfo);
        return "redirect:/user/useradmin";
    }

    @PostMapping("/register")
    @ResponseBody()
    public String getUserInfo(UserInfo userInfo){
        int i = userMapper.getUserInfo(userInfo);
        if(i==1){
            return "1";
        }else{
            return "0";}
    }

    //@GetMapping("/findpasword{id}")
    //public String findpasswordPage(@PathVariable("id") Integer UserID, Model model){
    // UserInfo userInfo = userMapper.getUserByID(UserID);
    //  model.addAttribute("userInfo",userInfo);
    //  return "login";
    //}


    @GetMapping("/findpassword1")
    public String findpassword1(){
        return "findpassword1";
    }

    @PostMapping("/findpassword1")
    public String findpassword2(@RequestParam("UserPhone") String UserPhone,
                                @RequestParam("Answer") String Answer,
                                HttpSession session){
        UserInfo userInfo = userMapper.findpassword1(UserPhone,Answer);
        if (userInfo!=null){
            session.setAttribute("changeUInfo",userInfo);
            return "redirect:/user/findpassword2";
        }
        return "redirect:/user/findpassword1";
    }
    @GetMapping("/findpassword2")
    public String findpassword2(HttpSession session){
        return "findpassword2";
    }
    @PostMapping("/findpassword2")
    public String findpassword2(@RequestParam("Password") String Password,
                                HttpSession session){
        UserInfo userInfo =(UserInfo)session.getAttribute("changeUInfo");
        //  userInfo.getUserID(),Password
        int i = userMapper.findpassword2(Password,userInfo.getUserID());
        return "redirect:/user/login";
    }

    @GetMapping("/updateuser/{id}")
    public String updatePage(@PathVariable("id") Integer UserID, Model model){
        UserInfo userInfo = userMapper.getUserByID(UserID);
        model.addAttribute("userInfo", userInfo);
        return "updateuser";
    }

    /**
     *
     * @param userInfo
     * @param file 上传用户头像
     * @return
     */
    @PostMapping("/updateuser")
    public String updateUserInfo(UserInfo userInfo,@RequestParam("filepic")MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUpLoadFilePath();
        fileName = System.currentTimeMillis()+fileName;
        try{
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userInfo.setUser_image_url(fileName);
        int i = userMapper.updateUserByID(userInfo);
        return "redirect:/user/useradmin";
    }


    @GetMapping("/deluser/{id}")
    public String delPage(@PathVariable("id") Integer UserID, Model model){
        UserInfo userInfo = userMapper.getUserByID(UserID);
        model.addAttribute("chat",userInfo);
        return "deleteuser";
    }


    @PostMapping("/deluser")
    public String delUserByID(UserInfo deluser){
        int i =userMapper.deluser(deluser);
        return "redirect:/user/userdmin";
    }



    @GetMapping("/backstage")
    public String backstagePage() {
        return "backstage";
    }

    @GetMapping("/index1")
    public String index1Page() {
        return "index1";
    }
    @GetMapping("/login2")
    public String User2Login(){
        return "login2";
    }




    //购物车
    @PostMapping("/addshopping")
    public String collections(HttpSession session,
                              @RequestParam("PositionID") Integer PositionID) {
        UserInfo userInfo = (UserInfo) session.getAttribute( "UserInfo" );
        Integer UserID = userInfo.getUserID();
        Integer i = collectionsMapper.addshopping( UserID,PositionID );
        return "redirect:/user/collections";
    }

    @GetMapping("/shoppingcar")
    public String shoppingcarPage(Model model,HttpSession session) {
        UserInfo userInfo=(UserInfo) session.getAttribute("UserInfo");
        List<CollectionsInfo> list1 = collectionsMapper.getAllcollections(userInfo.getUserID());
        List<CollectionsInfo> list2 =collectionsMapper.getcollections( userInfo.getUserID() );
        model.addAttribute("user",list1);
        model.addAttribute("coll",list2);
        return "collections";
    }

    //删除购物车
    @GetMapping("/dell/{id}")
    public String delshopping(@PathVariable("id") Integer CollectionsID){
        Integer i =collectionsMapper.dell( CollectionsID );
        return "redirect:/user/shoppingcar";
    }

    //查看详情

    @GetMapping("/detaill/{id}")
    public  String detail(@PathVariable("id")Integer PositionID,Model model){
        CollectionsInfo collections = collectionsMapper.getCompany(PositionID);
        model.addAttribute("posi",collections);
        return "detail";
    }

}








