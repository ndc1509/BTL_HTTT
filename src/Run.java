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
        
        Action khong_bi_suy_giam_nhan_thuc = f -> System.out.println("Không bị suy giảm nhận thức. Cách sinh hoạt phòng tránh suy giảm nhận thức\n"
                + "- Hoạt động trí não: đọc sách báo, tham gia sinh hoạt cộng đồng\n" +
                "- Tập thể dục đều đặn, nhẹ nhàng\n" +
                "- Giữ tinh thần lạc quan, vui vẻ\n" +
                "- Không sử dụng rượu bia, thuốc lá\n" +
                "- Kiểm tra sức khỏe định kì và khám bệnh sớm khi có triệu chứng\n" +
                "- Ăn uống lành mạnh, hạn chế ăn mặn, đường và cholesterol, ăn nhiều rau quả");        
        Action bi_suy_giam_nhan_thuc = f -> System.out.println("Bị suy giảm nhận thức, "
                + "cần đi khám tại bệnh viện chuyên khoa");
        Action loai_bo_thuoc = f -> System.out.println("Xem xét lại thuốc và loại bỏ nếu có thể");
        Action kiem_soat_benh_tim_mach_noi_tiet = f -> System.out.println("Cần kiểm soát và điều trị tốt bệnh tim mạch, nội tiết:\n"
                + "- Đo huyết áp hàng ngày\n"
                + "- Kiểm soát đường máu, lượng mỡ trong máu");
        Action phong_tranh_nguy_co_dot_quy_tai_bien = f -> System.out.println("Cần phòng tránh nguy cơ tái phát đột quỵ, tai biến\n"
                + "- Ăn uống lành mạnh, hạn chế ăn mặn, đường và cholesterol, ăn nhiều rau quả\n"
                + "- Ngủ đúng giờ đủ giấc\n"
                + "- Không tắm lạnh, tắm khuya vào buổi tối\n"
                + "- Không sử dụng rượu bia, thuốc lá\n"
                + "- Uống thuốc đúng giờ đúng đơn \n"
                + "- Kiểm tra sức khỏe định kì và khám bệnh sớm khi có triệu chứng");
        Action tu_van_them_suy_dinh_duong = f -> System.out.println("Cần tư vấn về dinh dưỡng");
        
        Rule sgnt_1 = new BaseRule("Không bị suy giảm nhận thức",1,false,khong_bi, khong_bi_suy_giam_nhan_thuc);
        Rule sgnt_2 = new BaseRule("Bị suy giảm nhận thức",1,false,bi, bi_suy_giam_nhan_thuc);
        Rule sgnt_3 = new BaseRule("Loại bỏ thuốc", 1, false, hoi_them_1, loai_bo_thuoc);
        Rule sgnt_4 = new BaseRule("Phòng tránh đột quỵ, tai biến", 1, false, hoi_them_2, phong_tranh_nguy_co_dot_quy_tai_bien);
        Rule sgnt_5 = new BaseRule("Kiểm soát bệnh tim mạch nội tiết", 1, false, hoi_them_3, kiem_soat_benh_tim_mach_noi_tiet);
        Rule sgnt_6 = new BaseRule("Tư vấn thêm về dinh dưỡng", 1, false, hoi_them_4, tu_van_them_suy_dinh_duong);
        
        RuleEngine engine = new RuleEngine();
        
        List<FactPair> facts = new ArrayList<>();
        facts.add(new FactPair("van de", "hay quen")); //"hay quen" Hoặc "khoxacdinhkhongthoigian"
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
