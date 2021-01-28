package com.example.databox.Controller;
import java.util.List;

import com.example.databox.Entity.ChatInfo;
import com.example.databox.Entity.PositionInfo;
import com.example.databox.Mapper.PositionMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("data")
public class PositionController {
    @Autowired
    private PositionMapper positionMapper;

//    @GetMapping("/positionadmin")
//    public String getAllPosition(Model model) {
//        List<PositionInfo> positionInfoLists = positionMapper.findAllPosition();
//        model.addAttribute("Position",positionInfoLists);
//        return "positionadmin";
//    }

    @GetMapping("/addposition")
    public String addpositionInfo() {
        return "addposition";
    }


    @PostMapping("/addposition")
    public  String addPositionInfo(PositionInfo positionInfo){
        int i = positionMapper.addPositionInfo(positionInfo);
        return "redirect:/data/positionadmin";
    }

    @GetMapping("/updateposition/{id}")
    public String updatepositionPage(@PathVariable("id")Integer PositionID,Model model){
        PositionInfo positionInfo = positionMapper.getPositionByid(PositionID);
        model.addAttribute("position",positionInfo);
        return "updateposition";
    }

    @PostMapping("/updateposition")
    public String updatePositionByID(PositionInfo PositionID){
        int i = positionMapper.updatePositionByID(PositionID);
        return "redirect:/data/positionadmin";
    }

    @RequestMapping("/positionadmin")
    public String getPositionID(@RequestParam(value="pageIndex",defaultValue = "1") Integer pageIndex,
                            @RequestParam(value="pageSize",defaultValue = "5") Integer pageSize,
                            @RequestParam(value="Position",defaultValue = "") String Position, Model model){
        PageHelper.startPage(pageIndex,pageSize);
        List<PositionInfo> lists=null;
        PageInfo<PositionInfo> positionInfoLists=null;
        if(Position.isEmpty()){
            lists=positionMapper.getAllPosition(pageIndex,pageSize);
        }else{
            lists=positionMapper.findPositionByID(pageIndex,pageSize,Position);
        }
        PageInfo<PositionInfo> pages=new PageInfo<>(lists);
        model.addAttribute("data",pages);
        model.addAttribute("Position", Position);
        return "positionadmin";
    }

    @GetMapping("/deleteposition/{id}")
    public String deletepositionPage(@PathVariable("id") Integer CompositionID,Model model){
        PositionInfo positionInfo = positionMapper.getPositionByid(CompositionID);
        model.addAttribute("position",positionInfo);
        return "deleteposition";
    }
    @PostMapping("/deleteposition")
    public String deletePositionByID(PositionInfo CompositionID){
        int i = positionMapper.deletePositionByID(CompositionID);
        return "redirect:/data/positionadmin";
    }




}
