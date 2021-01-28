package com.example.databox.Controller;

import com.example.databox.Entity.ChatInfo;
import com.example.databox.Entity.DataInfo;
import com.example.databox.Entity.UserInfo;
import com.example.databox.Mapper.ChatMapper;
import com.example.databox.Mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.jsqlparser.statement.select.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.pkcs11.wrapper.Constants;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("data")
public class ChatController {
    @Autowired
    private ChatMapper chatmapper;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/chatadmin")
    public String getUserID(@RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                            @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize,
                            @RequestParam(value="UserName",defaultValue = "") String UserName, Model model){
        PageHelper.startPage(pageIndex,pageSize);
        List<ChatInfo> lists=null;
        PageInfo<ChatInfo> listInfo=null;
        if(UserName.isEmpty()){
            lists=chatmapper.getAllUser(pageIndex,pageSize);
        }else{
            lists=chatmapper.findUserByUserID(pageIndex,pageSize,UserName);
        }
        PageInfo<ChatInfo> pages=new PageInfo<>(lists);
        model.addAttribute("data",pages);
        model.addAttribute("UserName",UserName);
        return "chatadmin";
    }
    //chatadmin某条数据的详情
    @GetMapping("/chatdetail/{id}")
    public String detailPage(@PathVariable("id") Integer UserID, Model model){
        ChatInfo chatInfo = chatmapper.getChatByid(UserID);
        model.addAttribute("chat",chatInfo);
        return "chatdetail";
    }
    @GetMapping("/addchat")
    public String addChatInfo(){
        return "addchat"; }

    @PostMapping("/addchat")
    public String addChatInfo(ChatInfo chatInfo){
        int i=chatmapper.savechat(chatInfo);
        return "redirect:/data/chatadmin";
    }
    @GetMapping("/updatechat/{id}")
    public String updatePage(@PathVariable("id") Integer UserID, Model model){
        ChatInfo chatInfo = chatmapper.getChatByid(UserID);
        model.addAttribute("chat",chatInfo);
        return "updatechat";
    }
    @PostMapping("/updatechat")
    public String updateUserByID(ChatInfo chat){
        int i =chatmapper.updateUserByID(chat);
        return "redirect:/data/chatadmin";
    }
    @GetMapping("/delchat/{id}")
    public String delPage(@PathVariable("id") Integer UserID, Model model){
        ChatInfo chatInfo = chatmapper.getChatByid(UserID);
        model.addAttribute("chat",chatInfo);
        return "deletechat";
    }
    @PostMapping("/delchat")
    public String delUserByID(ChatInfo delchat){
        int i =chatmapper.delchat(delchat);
        return "redirect:/data/chatadmin";
    }

    //chat页面的传值
    @GetMapping("/chat")
    public String pagechat(@RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                           @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize,
                           @RequestParam(value = "id",defaultValue = "0") Integer TopicNumber,Model model){
        PageHelper.startPage(pageIndex,pageSize);
        String Topic="";
        List<ChatInfo> list=null;
        PageInfo<ChatInfo> listInfo=null;
        if(TopicNumber == 1)
            Topic="面试经验";
        if(TopicNumber == 2)
            Topic="简历";
        if(TopicNumber == 3)
            Topic="薪酬福利";
        if(TopicNumber == 4)
            Topic="职业发展规划";
        if(TopicNumber == 5)
            Topic="职位选择";
        if(TopicNumber == 0){
            Topic="所有分类";
            list=chatmapper.getAllUser(pageIndex,pageSize);
        }else
        {
            list=chatmapper.findUserByTopic(Topic);
        }
        PageInfo<ChatInfo> pages=new PageInfo<>(list);
        List<ChatInfo> lists= chatmapper.getchatno();
        model.addAttribute("chatuser",pages);
        model.addAttribute("chat", lists);
        return "chat";
    }

    //chat1前端传值,根据分类查询
    @GetMapping("/chat1")
    public String getChat(@RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                          @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize,
                          @RequestParam(value = "id",defaultValue = "0") Integer TopicNumber,
                          Model model) {
        PageHelper.startPage(pageIndex,pageSize);
        String Topic="";
        List<ChatInfo> list=null;
        PageInfo<ChatInfo> listInfo=null;
        if(TopicNumber == 1)
            Topic="面试经验";
        if(TopicNumber == 2)
            Topic="简历";
        if(TopicNumber == 3)
            Topic="薪酬福利";
        if(TopicNumber == 4)
            Topic="职业发展规划";
        if(TopicNumber == 5)
            Topic="职位选择";
        if(TopicNumber == 0){
            Topic="所有分类";
            list=chatmapper.getchatno();
        }else if(Topic.isEmpty()){
            list=chatmapper.getchatno();
        }else{
            list=chatmapper.findUserByTopic(Topic);
        }
        PageInfo<ChatInfo> pages=new PageInfo<>(list);
        List<ChatInfo> lists= chatmapper.getchatno();
        model.addAttribute("chatuser",pages);
        model.addAttribute("chat", lists);
        return "chat1";
    }
    //chat页面接收用户发贴内容
    @PostMapping("/chat1")
    public String getChat(  @RequestParam("Topic") String Topic,
                            @RequestParam("Content") String Content,
                            @RequestParam("Title") String Title,
                            HttpSession session){
        UserInfo userInfo=(UserInfo) session.getAttribute("UserInfo");
        String UserPhone = userInfo.getUserPhone();
        String Password = userInfo.getPassword();
        int i=chatmapper.addchat(UserPhone,Password,Topic,Content,Title);
        if(i==1){
            return "redirect:/data/chat1";
        }
        return "发表内容有误";
    }

}
