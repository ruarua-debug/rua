package com.example.databox.Controller;

import com.example.databox.Entity.ChartInfo;
import com.example.databox.Mapper.ChartMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("data")
public class ChartController {

    @Autowired
    private ChartMapper chartMapper;

    //chart1图表展示
//    @GetMapping("/chart1")
//    public String chart1Page(Model model){
//        List<Integer> ranklists= cityMapper.getAvgSalary();
//        model.addAttribute("rank",ranklists);
//        return "chart1";
//    }


    /**
     *
     * @param model 模型
     * @return
     */
    //数据挖掘职位图表
    @GetMapping("/position1")
    public String chart1Page(Model model){
        //南丁格尔玫瑰图
        List<Integer> rank11lists= chartMapper.getAvgSalary11();
        List<Integer> rank12lists= chartMapper.getAvgSalary12();
        List<Integer> rank141lists= chartMapper.getAvgSalary141();//柱状图调用
        List<Integer> rank142lists= chartMapper.getAvgSalary142();//柱状图调用
        List<String> rank143lists= chartMapper.getAvgSalary143();//柱状图调用
//        List<String> rank144lists= chartMapper.getAvgSalary144();
        List<Integer> lists = chartMapper.getSalary1City();

        //南丁格尔玫瑰图
        model.addAttribute("rank11",rank11lists);
        model.addAttribute("rank12",rank12lists);
        model.addAttribute("rank141",rank141lists);
        model.addAttribute("rank142",rank142lists);
        model.addAttribute("rank143",rank143lists);
//        model.addAttribute("rank144",rank144lists);
        model.addAttribute("chart51data",lists);



        //柱状图
        List<Integer> rank111lists= chartMapper.getAvgSalary111();
        List<String> rank1111lists= chartMapper.getAvgSalary1111();
        model.addAttribute("rank111",rank111lists);
        model.addAttribute("rank1111",rank1111lists);



        //极坐标
        List<ChartInfo> lists411 = chartMapper.getSalary411();
        List<Integer> data411 =  new ArrayList<>();
        for (ChartInfo a:lists411) {
            data411.add(a.getMinSalary());
            data411.add(a.getAvgSalary());
            data411.add(a.getMaxSalary());
        }
        // CityInfo  a = ((CityInfo)(lists1));

        List<ChartInfo> lists412 = chartMapper.getSalary412();
        List<Integer> data412 =  new ArrayList<>();
        for (ChartInfo b:lists412) {
            data412.add(b.getMinSalary());
            data412.add(b.getAvgSalary());
            data412.add(b.getMaxSalary());
        }

        List<ChartInfo> lists413 = chartMapper.getSalary413();
        List<Integer> data413 =  new ArrayList<>();
        for (ChartInfo c:lists413) {
            data413.add(c.getMinSalary());
            data413.add(c.getAvgSalary());
            data413.add(c.getMaxSalary());
        }

        List<ChartInfo> lists414 = chartMapper.getSalary414();
        List<Integer> data414 =  new ArrayList<>();
        for (ChartInfo d:lists414) {
            data414.add(d.getMinSalary());
            data414.add(d.getAvgSalary());
            data414.add(d.getMaxSalary());
        }

        List<ChartInfo> lists415 = chartMapper.getSalary415();
        List<Integer> data415 =  new ArrayList<>();
        for (ChartInfo e:lists415) {
            data415.add(e.getMinSalary());
            data415.add(e.getAvgSalary());
            data415.add(e.getMaxSalary());
        }

        List<ChartInfo> lists416 = chartMapper.getSalary416();
        List<Integer> data416 =  new ArrayList<>();
        for (ChartInfo f:lists416) {
            data416.add(f.getMinSalary());
            data416.add(f.getAvgSalary());
            data416.add(f.getMaxSalary());
        }

        List<ChartInfo> lists417 = chartMapper.getSalary417();
        List<Integer> data417 =  new ArrayList<>();
        for (ChartInfo g:lists417) {
            data417.add(g.getMinSalary());
            data417.add(g.getAvgSalary());
            data417.add(g.getMaxSalary());
        }

        List<ChartInfo> lists418 = chartMapper.getSalary418();
        List<Integer> data418 =  new ArrayList<>();
        for (ChartInfo h:lists418) {
            data418.add(h.getMinSalary());
            data418.add(h.getAvgSalary());
            data418.add(h.getMaxSalary());
        }

        model.addAttribute("data411",data411);
        model.addAttribute("data412",data412);
        model.addAttribute("data413",data413);
        model.addAttribute("data414",data414);
        model.addAttribute("data415",data415);
        model.addAttribute("data416",data416);
        model.addAttribute("data417",data417);
        model.addAttribute("data418",data418);



        //不同城市不同行业工资比较堆积面积图
        List<Integer> salary1lists = chartMapper.getAvgSalary1ByCity();
        List<String> salary11lists = chartMapper.getAvgSalary11ByCity();
        List<Integer> salary2lists = chartMapper.getAvgSalary2ByCity();
        List<Integer> salary3lists = chartMapper.getAvgSalary3ByCity();
        List<Integer> salary4lists = chartMapper.getAvgSalary4ByCity();
        model.addAttribute("data1", salary1lists);
        model.addAttribute("data11", salary11lists);
        model.addAttribute("data2", salary2lists);
        model.addAttribute("data3", salary3lists);
        model.addAttribute("data4", salary4lists);

        //表格
        List<ChartInfo> list11 = chartMapper.showcitydata();
        List<ChartInfo> list12 = chartMapper.showsalary();
        model.addAttribute("table1",list11);
        model.addAttribute("table2",list12);
        return "position1";
    }



    /**
     *
     * @param model 模型
     * @return
     */
    //chart13图表展示  散点图
    @GetMapping("/chart13")
    public String chart13Page(Model model){
        List<Integer> rank13lists= chartMapper.getAvgSalary13();
        model.addAttribute("rank13",rank13lists);
        return "chart13";
    }




    //人事经理职务图表
    @GetMapping("/position2")
    public String chart2Page(Model model){
        List<Integer> rank21lists= chartMapper.getAvgSalary21();//柱状图
        List<String> rank211lists= chartMapper.getAvgSalary211();//柱状图
        List<Integer> rank22lists= chartMapper.getAvgSalary22();
        List<Integer> rank241lists= chartMapper.getAvgSalary241();
        List<Integer> rank242lists= chartMapper.getAvgSalary242();
        List<Integer> lists = chartMapper.getSalary4City();

        model.addAttribute("rank21",rank21lists);//柱状图
        model.addAttribute("rank211",rank211lists);//柱状图
        model.addAttribute("rank22",rank22lists);
        model.addAttribute("rank241",rank241lists);
        model.addAttribute("rank242",rank242lists);
        model.addAttribute("chart54data",lists);



        //极坐标图
        List<ChartInfo> lists441 = chartMapper.getSalary441();
        List<Integer> data441 =  new ArrayList<>();
        for (ChartInfo a:lists441) {
            data441.add(a.getMinSalary());
            data441.add(a.getAvgSalary());
            data441.add(a.getMaxSalary());
        }
        // CityInfo  a = ((CityInfo)(lists1));

        List<ChartInfo> lists442 = chartMapper.getSalary442();
        List<Integer> data442 =  new ArrayList<>();
        for (ChartInfo b:lists442) {
            data442.add(b.getMinSalary());
            data442.add(b.getAvgSalary());
            data442.add(b.getMaxSalary());
        }

        List<ChartInfo> lists443 = chartMapper.getSalary443();
        List<Integer> data443 =  new ArrayList<>();
        for (ChartInfo c:lists443) {
            data443.add(c.getMinSalary());
            data443.add(c.getAvgSalary());
            data443.add(c.getMaxSalary());
        }

        List<ChartInfo> lists444 = chartMapper.getSalary444();
        List<Integer> data444 =  new ArrayList<>();
        for (ChartInfo d:lists444) {
            data444.add(d.getMinSalary());
            data444.add(d.getAvgSalary());
            data444.add(d.getMaxSalary());
        }

        List<ChartInfo> lists445 = chartMapper.getSalary445();
        List<Integer> data445 =  new ArrayList<>();
        for (ChartInfo e:lists445) {
            data445.add(e.getMinSalary());
            data445.add(e.getAvgSalary());
            data445.add(e.getMaxSalary());
        }

        List<ChartInfo> lists446 = chartMapper.getSalary446();
        List<Integer> data446 =  new ArrayList<>();
        for (ChartInfo f:lists446) {
            data446.add(f.getMinSalary());
            data446.add(f.getAvgSalary());
            data446.add(f.getMaxSalary());
        }

        List<ChartInfo> lists447 = chartMapper.getSalary447();
        List<Integer> data447 =  new ArrayList<>();
        for (ChartInfo g:lists447) {
            data447.add(g.getMinSalary());
            data447.add(g.getAvgSalary());
            data447.add(g.getMaxSalary());
        }

        List<ChartInfo> lists448 = chartMapper.getSalary448();
        List<Integer> data448 =  new ArrayList<>();
        for (ChartInfo h:lists448) {
            data448.add(h.getMinSalary());
            data448.add(h.getAvgSalary());
            data448.add(h.getMaxSalary());
        }

        model.addAttribute("data441",data441);
        model.addAttribute("data442",data442);
        model.addAttribute("data443",data443);
        model.addAttribute("data444",data444);
        model.addAttribute("data445",data445);
        model.addAttribute("data446",data446);
        model.addAttribute("data447",data447);
        model.addAttribute("data448",data448);


        //不同城市不同行业工资比较堆积面积图
        List<Integer> salary1lists = chartMapper.getAvgSalary1ByCity();
        List<Integer> salary2lists = chartMapper.getAvgSalary2ByCity();
        List<Integer> salary3lists = chartMapper.getAvgSalary3ByCity();
        List<Integer> salary4lists = chartMapper.getAvgSalary4ByCity();
        model.addAttribute("data1", salary1lists);
        model.addAttribute("data2", salary2lists);
        model.addAttribute("data3", salary3lists);
        model.addAttribute("data4", salary4lists);

        //表格
        List<ChartInfo> list21 = chartMapper.showrenshi();
        List<ChartInfo> list22 = chartMapper.showrenxue();
        model.addAttribute("table3",list21);
        model.addAttribute("table4",list22);

        return "position2";
    }









    //chart23图表展示  散点图
    @GetMapping("/chart23")
    public String chart23Page(Model model){
        List<Integer> rank23lists= chartMapper.getAvgSalary23();
        model.addAttribute("rank23",rank23lists);
        return "chart23";
    }


    /**
     *
     * @param model 模型
     * @return
     */

    //C++游戏开发工程师  图表
    @GetMapping("/position3")
    public String chart3Page(Model model){
        List<Integer> rank31lists= chartMapper.getAvgSalary31();
        List<String> rank311lists= chartMapper.getAvgSalary311();
        List<Integer> rank32lists= chartMapper.getAvgSalary32();
        List<Integer> rank341lists= chartMapper.getAvgSalary341();
        List<Integer> rank342lists= chartMapper.getAvgSalary342();
        List<Integer> lists = chartMapper.getSalary3City();

        model.addAttribute("rank31",rank31lists);
        model.addAttribute("rank311",rank311lists);
        model.addAttribute("rank32",rank32lists);
        model.addAttribute("rank341",rank341lists);
        model.addAttribute("rank342",rank342lists);
        model.addAttribute("chart53data",lists);
        //C++游戏开发
        List<ChartInfo> lists431 = chartMapper.getSalary431();
        List<Integer> data431 =  new ArrayList<>();
        for (ChartInfo a:lists431) {

            data431.add(a.getMinSalary());
            data431.add(a.getAvgSalary());
            data431.add(a.getMaxSalary());
        }
        // CityInfo  a = ((CityInfo)(lists1));

        List<ChartInfo> lists432 = chartMapper.getSalary432();
        List<Integer> data432 =  new ArrayList<>();
        for (ChartInfo b:lists432) {

            data432.add(b.getMinSalary());
            data432.add(b.getAvgSalary());
            data432.add(b.getMaxSalary());
        }
        List<ChartInfo> lists433 = chartMapper.getSalary433();
        List<Integer> data433 =  new ArrayList<>();
        for (ChartInfo c:lists433) {

            data433.add(c.getMinSalary());
            data433.add(c.getAvgSalary());
            data433.add(c.getMaxSalary());
        }
        List<ChartInfo> lists434 = chartMapper.getSalary434();
        List<Integer> data434 =  new ArrayList<>();
        for (ChartInfo d:lists434) {

            data434.add(d.getMinSalary());
            data434.add(d.getAvgSalary());
            data434.add(d.getMaxSalary());
        }
        List<ChartInfo> lists435 = chartMapper.getSalary435();
        List<Integer> data435 =  new ArrayList<>();
        for (ChartInfo e:lists435) {

            data435.add(e.getMinSalary());
            data435.add(e.getAvgSalary());
            data435.add(e.getMaxSalary());
        }
        List<ChartInfo> lists436 = chartMapper.getSalary436();
        List<Integer> data436 =  new ArrayList<>();
        for (ChartInfo f:lists436) {

            data436.add(f.getMinSalary());
            data436.add(f.getAvgSalary());
            data436.add(f.getMaxSalary());
        }
        List<ChartInfo> lists437 = chartMapper.getSalary437();
        List<Integer> data437 =  new ArrayList<>();
        for (ChartInfo g:lists437) {

            data437.add(g.getMinSalary());
            data437.add(g.getAvgSalary());
            data437.add(g.getMaxSalary());
        }
        List<ChartInfo> lists438 = chartMapper.getSalary438();
        List<Integer> data438 =  new ArrayList<>();
        for (ChartInfo h:lists438) {

            data438.add(h.getMinSalary());
            data438.add(h.getAvgSalary());
            data438.add(h.getMaxSalary());
        }
        model.addAttribute("data431",data431);
        model.addAttribute("data432",data432);
        model.addAttribute("data433",data433);
        model.addAttribute("data434",data434);
        model.addAttribute("data435",data435);
        model.addAttribute("data436",data436);
        model.addAttribute("data437",data437);
        model.addAttribute("data438",data438);
        //表格
        List<ChartInfo> list31 = chartMapper.showshuren();
        List<ChartInfo> list32 = chartMapper.showc();
        model.addAttribute("table5",list31);
        model.addAttribute("table6",list32);



        return "position3";
    }



    /**
     *
     * @param model 模型
     * @return
     */

    //chart23图表展示  散点图
    @GetMapping("/chart33")
    public String chart33Page(Model model){
        List<Integer> rank33lists= chartMapper.getAvgSalary33();
        model.addAttribute("rank33",rank33lists);
        return "chart33";
    }


    //web前端开发  图表
    @GetMapping("/position4")
    public String chart4Page(Model model){
        List<Integer> rank41lists= chartMapper.getAvgSalary41();
        List<String> rank411lists= chartMapper.getAvgSalary411();
        List<Integer> rank42lists= chartMapper.getAvgSalary42();
        List<Integer> rank441lists= chartMapper.getAvgSalary441();
        List<Integer> rank442lists= chartMapper.getAvgSalary442();
        List<Integer> lists = chartMapper.getSalary2City();

        model.addAttribute("rank41",rank41lists);
        model.addAttribute("rank411",rank411lists);
        model.addAttribute("rank42",rank42lists);
        model.addAttribute("rank441",rank441lists);
        model.addAttribute("rank442",rank442lists);
        model.addAttribute("chart52data",lists);
        //堆积柱状图
        List<ChartInfo> lists421 = chartMapper.getSalary421();
        List<Integer> data421 =  new ArrayList<>();
        for (ChartInfo a:lists421) {
            data421.add(a.getMinSalary());
            data421.add(a.getAvgSalary());
            data421.add(a.getMaxSalary());
        }
        // CityInfo  a = ((CityInfo)(lists1));

        List<ChartInfo> lists422 = chartMapper.getSalary422();
        List<Integer> data422 =  new ArrayList<>();
        for (ChartInfo b:lists422) {
            data422.add(b.getMinSalary());
            data422.add(b.getAvgSalary());
            data422.add(b.getMaxSalary());
        }

        List<ChartInfo> lists423 = chartMapper.getSalary423();
        List<Integer> data423 =  new ArrayList<>();
        for (ChartInfo c:lists423) {
            data423.add(c.getMinSalary());
            data423.add(c.getAvgSalary());
            data423.add(c.getMaxSalary());
        }

        List<ChartInfo> lists424 = chartMapper.getSalary424();
        List<Integer> data424 =  new ArrayList<>();
        for (ChartInfo d:lists424) {
            data424.add(d.getMinSalary());
            data424.add(d.getAvgSalary());
            data424.add(d.getMaxSalary());
        }

        List<ChartInfo> lists425 = chartMapper.getSalary425();
        List<Integer> data425 =  new ArrayList<>();
        for (ChartInfo e:lists425) {
            data425.add(e.getMinSalary());
            data425.add(e.getAvgSalary());
            data425.add(e.getMaxSalary());
        }

        List<ChartInfo> lists426 = chartMapper.getSalary426();
        List<Integer> data426 =  new ArrayList<>();
        for (ChartInfo f:lists426) {
            data426.add(f.getMinSalary());
            data426.add(f.getAvgSalary());
            data426.add(f.getMaxSalary());
        }

        List<ChartInfo> lists427 = chartMapper.getSalary427();
        List<Integer> data427 =  new ArrayList<>();
        for (ChartInfo g:lists427) {
            data427.add(g.getMinSalary());
            data427.add(g.getAvgSalary());
            data427.add(g.getMaxSalary());
        }

        List<ChartInfo> lists428 = chartMapper.getSalary428();
        List<Integer> data428 =  new ArrayList<>();
        for (ChartInfo h:lists428) {
            data428.add(h.getMinSalary());
            data428.add(h.getAvgSalary());
            data428.add(h.getMaxSalary());
        }

        model.addAttribute("data421",data421);
        model.addAttribute("data422",data422);
        model.addAttribute("data423",data423);
        model.addAttribute("data424",data424);
        model.addAttribute("data425",data425);
        model.addAttribute("data426",data426);
        model.addAttribute("data427",data427);
        model.addAttribute("data428",data428);

        List<ChartInfo> list41 = chartMapper.showwebsalary();
        model.addAttribute("table7",list41);

        return "position4";
    }


    //chart23图表展示  散点图
    @GetMapping("/chart43")
    public String chart43Page(Model model){
        List<Integer> rank43lists= chartMapper.getAvgSalary43();
        model.addAttribute("rank43",rank43lists);
        return "chart43";
    }



    @GetMapping("/abc")
    public String positionabcPage() {
        return "abc";
    }




    //chart2图表展示
//    @GetMapping("/position2")
//    public String chart2Page(Model model){
//        List<Integer> rank1lists= cityMapper.getAvgSalary2();
//        model.addAttribute("rank2",rank1lists);
//        return "position2";
//    }


    //    @GetMapping("/position1")
//    public String position1Page() {
//        return "position1";
//    }
//
//chart3图表展示
//    @GetMapping("/chart4")
//        public String chart4Page(Model model){
//         List<Integer> rank4lists= cityMapper.getAvgSalary4();
//         model.addAttribute("rank4",rank4lists);
//        return "chart4";
//        }
//
//
//
//ho后台管理
    @GetMapping("/addchart")
    public String addChartInfo(Model model) {
        return "addchart";
    }

    @PostMapping("/addchart")
    public String addChartInfo(ChartInfo chartInfo){
        int i = chartMapper.addChartInfo(chartInfo);
        return "redirect:/data/chart";
    }

    //
    //更新



    /**
     *
     * @param CityID 城市编码
     * @param model 模型
     * @return
     */
    @GetMapping("/updatechart/{id}")
    public String updatechartPage(@PathVariable("id") Integer CityID, Model model) {
        ChartInfo chartInfo = chartMapper.findChartByID(CityID);
        model.addAttribute("chart", chartInfo);
        return "updatechart";
    }

    @PostMapping("/updatechart")
    public String updateChartByID(ChartInfo chartInfo){
        int i = chartMapper.updateChartByID(chartInfo);
        return "redirect:/data/chart";
    }
    //分页遍历

    /**
     * @param pageIndex chart的分页码
     * @param pageSize 一页的数据量
     * @param City 城市
     * @param model 模型
     * @return
     */
    @RequestMapping("/chart")
    public String getChartID(@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "City", defaultValue = "") String City, Model model) {
        PageHelper.startPage(pageIndex, pageSize);
        List<ChartInfo> lists = null;
        PageInfo<ChartInfo> chartInfoLists = null;
        if (City.isEmpty()) {
            lists = chartMapper.getAllChart(pageIndex, pageSize);
        } else {
            lists = chartMapper.findChartByChartID(pageIndex, pageSize, City);
        }
        PageInfo<ChartInfo> pages = new PageInfo<>(lists);
        model.addAttribute("data", pages);
        model.addAttribute("City", City);
        return "chart";
    }
    //删除
    @GetMapping("/deletechart/{id}")
    public String deletechartPage(@PathVariable("id") Integer CityID, Model model) {
        ChartInfo chartInfo = chartMapper.findChartByID(CityID);
        model.addAttribute("chart", chartInfo);
        return "deletechart";
    }

    @PostMapping("/deletechart")
    public String deleteChartByID(ChartInfo chartInfo){
        int i = chartMapper.deleteChartByID(chartInfo);
        return "redirect:/data/chart";
    }




}
