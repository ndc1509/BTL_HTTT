/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import common.BaseRule;
import common.Rule;
import common.Condition;
import common.Fact;
import common.OrConditionGroup;
import common.ConditionGroup;
import common.Action;
import common.NotCondition;
import condition.*;
import engine.*;
import fact.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Cuong
 */
public class Run {
    public static void main(String[] args) {
        //DEMO
//        Condition male = new SimpleCondition("gender", "male");
//        Condition female = new SimpleCondition("gender", "female");
//        
//        Condition adult = new RangeCondition("age", 18, 100);
//        Condition notAdult = NotCondition.reverse(adult);
//        
//        Condition maleAdult = ConditionGroup.all(male, adult);
//        Condition femaleAdult = ConditionGroup.all(female, adult);
//        Condition maleNotAdult = ConditionGroup.all(male, notAdult);
//        Condition adultMaleOrFemale = ConditionGroup.all(ConditionGroup.any(male, female));
//       
//        Action print = f -> System.out.println("Rule fired");
//        Action printprint = ActionChain.all(Arrays.asList(print, print));
//        
//        Rule printWhenMaleNotAdult = new BaseRule("print when male not adult",1,false,maleNotAdult,printprint);
//        Rule printForFemaleAdult = new BaseRule("print for female adult",2,false,femaleAdult,print);
//        
//        RuleEngine engine = new RuleEngine();
//        
//        List<KVFactPair> facts = new ArrayList<>();
//        facts.add(new KVFactPair("gender", "male"));
//        facts.add(new KVFactPair("age", 10));
//        
//        Fact fact = new DefaultKVFact(new KVFactPairs(facts));
//        engine.runRules(Arrays.asList(printForFemaleAdult, printWhenMaleNotAdult), fact);
        
        //Suy giam nhan thuc
        Condition hay_quen = new SimpleCondition("van de", "hay quen");
        Condition kho_xac_dinh_khong_thoi_gian = new SimpleCondition("van de", "khoxacdinhkhongthoigian");
        
        Condition nho_tu_0 = new SimpleCondition("nho tu",0);
        Condition nho_tu_1 = new SimpleCondition("nho tu",1);
        Condition nho_tu_2 = new SimpleCondition("nho tu",2);
        Condition nho_tu_3 = new SimpleCondition("nho tu",3);
        
        Condition ve_dong_ho_0 = new SimpleCondition("ve duoc",0);
        Condition ve_dong_ho_1 = new SimpleCondition("ve duoc",1);
        Condition ve_dong_ho_2 = new SimpleCondition("ve duoc",2);
        
        Condition danh_gia_OK = ConditionGroup.any(
                ConditionGroup.all(OrConditionGroup.any(nho_tu_2, nho_tu_3), ve_dong_ho_2), 
                ConditionGroup.all(nho_tu_3, ve_dong_ho_1));
        
        Condition dung_nhieu_thuoc = new SimpleCondition("hoi them 1", "dung nhieu thuoc dong thoi");
        Condition tien_su_mach_mau_nao = new SimpleCondition("hoi them 2", "tien su benh mach mau nao");
        Condition tien_su_tim_mach = new SimpleCondition("hoi them 3", "tien su benh tim mach");
        Condition tien_su_noi_tiet = new SimpleCondition("hoi them 4", "tien su benh noi tiet");
        Condition suy_dinh_duong = new SimpleCondition("hoi them 5", "suy dinh duong");
        
        Condition khong_bi = ConditionGroup.all(OrConditionGroup.any(hay_quen, kho_xac_dinh_khong_thoi_gian), danh_gia_OK);
        Condition bi = ConditionGroup.all(ConditionGroup.any(hay_quen, kho_xac_dinh_khong_thoi_gian), NotCondition.reverse(danh_gia_OK));
        
        Condition hoi_them_1 = ConditionGroup.all(bi, dung_nhieu_thuoc);
        Condition hoi_them_2 = ConditionGroup.all(bi, tien_su_mach_mau_nao);
        Condition hoi_them_3 = ConditionGroup.all(bi, OrConditionGroup.any(tien_su_tim_mach, tien_su_noi_tiet));
        Condition hoi_them_4 = ConditionGroup.all(bi, suy_dinh_duong);
        
        Action khong_bi_suy_giam_nhan_thuc = f -> System.out.println("Kh??ng b??? suy gi???m nh???n th???c. C??ch sinh ho???t ph??ng tr??nh suy gi???m nh???n th???c\n"
                + "- Ho???t ?????ng tr?? n??o: ?????c s??ch b??o, tham gia sinh ho???t c???ng ?????ng\n" +
                "- T???p th??? d???c ?????u ?????n, nh??? nh??ng\n" +
                "- Gi??? tinh th???n l???c quan, vui v???\n" +
                "- Kh??ng s??? d???ng r?????u bia, thu???c l??\n" +
                "- Ki???m tra s???c kh???e ?????nh k?? v?? kh??m b???nh s???m khi c?? tri???u ch???ng\n" +
                "- ??n u???ng l??nh m???nh, h???n ch??? ??n m???n, ???????ng v?? cholesterol, ??n nhi???u rau qu???");        
        Action bi_suy_giam_nhan_thuc = f -> System.out.println("B??? suy gi???m nh???n th???c, "
                + "c???n ??i kh??m t???i b???nh vi???n chuy??n khoa");
        Action loai_bo_thuoc = f -> System.out.println("Xem x??t l???i thu???c v?? lo???i b??? n???u c?? th???");
        Action kiem_soat_benh_tim_mach_noi_tiet = f -> System.out.println("C???n ki???m so??t v?? ??i???u tr??? t???t b???nh tim m???ch, n???i ti???t:\n"
                + "- ??o huy???t ??p h??ng ng??y\n"
                + "- Ki???m so??t ???????ng m??u, l?????ng m??? trong m??u");
        Action phong_tranh_nguy_co_dot_quy_tai_bien = f -> System.out.println("C???n ph??ng tr??nh nguy c?? t??i ph??t ?????t qu???, tai bi???n\n"
                + "- ??n u???ng l??nh m???nh, h???n ch??? ??n m???n, ???????ng v?? cholesterol, ??n nhi???u rau qu???\n"
                + "- Ng??? ????ng gi??? ????? gi???c\n"
                + "- Kh??ng t???m l???nh, t???m khuya v??o bu???i t???i\n"
                + "- Kh??ng s??? d???ng r?????u bia, thu???c l??\n"
                + "- U???ng thu???c ????ng gi??? ????ng ????n \n"
                + "- Ki???m tra s???c kh???e ?????nh k?? v?? kh??m b???nh s???m khi c?? tri???u ch???ng");
        Action tu_van_them_suy_dinh_duong = f -> System.out.println("C???n t?? v???n v??? dinh d?????ng");
        
        Rule sgnt_1 = new BaseRule("Kh??ng b??? suy gi???m nh???n th???c",1,false,khong_bi, khong_bi_suy_giam_nhan_thuc);
        Rule sgnt_2 = new BaseRule("B??? suy gi???m nh???n th???c",1,false,bi, bi_suy_giam_nhan_thuc);
        Rule sgnt_3 = new BaseRule("Lo???i b??? thu???c", 1, false, hoi_them_1, loai_bo_thuoc);
        Rule sgnt_4 = new BaseRule("Ph??ng tr??nh ?????t qu???, tai bi???n", 1, false, hoi_them_2, phong_tranh_nguy_co_dot_quy_tai_bien);
        Rule sgnt_5 = new BaseRule("Ki???m so??t b???nh tim m???ch n???i ti???t", 1, false, hoi_them_3, kiem_soat_benh_tim_mach_noi_tiet);
        Rule sgnt_6 = new BaseRule("T?? v???n th??m v??? dinh d?????ng", 1, false, hoi_them_4, tu_van_them_suy_dinh_duong);
        
        RuleEngine engine = new RuleEngine();
        
        List<FactPair> facts = new ArrayList<>();
        facts.add(new FactPair("van de", "hay quen")); //"hay quen" Ho???c "khoxacdinhkhongthoigian"
        facts.add(new FactPair("nho tu", 3)); //Gioi han tu 0-3
        facts.add(new FactPair("ve duoc", 0)); //Gioi han tu 0-2
        facts.add(new FactPair("hoi them 3", "tien su benh tim mach"));
        facts.add(new FactPair("hoi them 1", "dung nhieu thuoc dong thoi")); //Them vao neu muon
        
        Fact fact = new DefaultFact(new FactPairs(facts));
        
        List<Rule> listRules = new ArrayList<>();
        listRules.add(sgnt_1);
        listRules.add(sgnt_2);
        listRules.add(sgnt_3);
        listRules.add(sgnt_4);
        listRules.add(sgnt_5);
        listRules.add(sgnt_6); //Nho phai them luat
        
        engine.runRules(listRules, fact);
    }
}
