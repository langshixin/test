package com.example.demo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.demo.entity.Combination;
import com.example.demo.entity.CourseStorage;
import com.example.demo.mapper.CombinationMapper;
import com.example.demo.mapper.CourseStorageMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * @author langshixin
 * @date 2022/9/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test {

    @Autowired
    private CourseStorageMapper courseStorageMapper;

    @Autowired
    private CombinationMapper combinationMapper;
    @org.junit.Test
    public void test9() throws Exception {
        // 配置规则.
        initFlowRules();
        for (int i = 0; i < 90; i++) {
            // 1.5.0 版本开始可以直接利用 try-with-resources 特性，自动 exit entry
            try (Entry entry = SphU.entry("HelloWorld")) {
                // 被保护的逻辑
                System.out.println("hello world");
            } catch (BlockException ex) {
                // 处理被流控的逻辑
                System.out.println("blocked!");
            }
            if (i == 30 || i == 60){
                Thread.sleep(60000);
            }
        }
    }

    private  void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

    @org.junit.Test
    public void test6() throws Exception {
        URL url = new URL("http://localhost:8089/test/hello");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        URL url1 = new URL("http://localhost:8088/test/hello");
        HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();
        System.out.println(con1.getContent());
        System.out.println(con.getContent());
    }
    @org.junit.Test
    public void test7() throws Exception {
        System.out.println(-1L ^ (-1L << 12));
    }
    @org.junit.Test
    public void test5(){
        Set<String> ids = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()-> ids.add(IdWorker.getIdStr())).start();
//            new Thread(){{
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        System.out.println(IdWorker.getIdStr());
//                    }
//                };
//            }}.start();
        }
        System.out.println(ids.size());
/*        Combination combination = new Combination();
        combination.setTitle("1242");
        combinationMapper.insert(combination);
        System.out.println(combination.getId());*/
    }


    @org.junit.Test
    public void test3() throws Exception {
//        if(1==1 || 2==3){
//            System.out.println(1);
//        }

        URL url = new URL("https://baidu.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setConnectTimeout(10000);
        con.setReadTimeout(10000);
    }

    @org.junit.Test
    public void parseHtml() throws Exception {
        URL url = new URL("https://search.jd.com/Search?keyword=iphone&pvid=bb3691fa032f405e93d87d94f541d560");
        Document parse = Jsoup.parse(url, 30000);
//        Element goodsList = parse.getElementById("J_goodsList");
//        Elements listElementsByTag = goodsList.getElementsByClass("gl-item");
        Element pageNO = parse.getElementById("J_bottomPage");
        Elements elementsByClass = pageNO.getElementsByClass("p-skip");
//        String b = pageNO.getElementsByClass("p-skip").eq(0).text();
//        System.out.println(b);
//        for (Element element : listElementsByTag) {
//            String img =element.getElementsByTag("img").attr("data-lazy-img");
//            String price = element.getElementsByClass("p-price").eq(0).text();
//            String title = element.getElementsByClass("p-name").eq(0).text();
//            System.out.print(" price："+price);
//            System.out.print(" img："+img);
//            System.out.println(" title："+title);
//        }
    }


    @org.junit.Test
    public void test2() throws Exception {
        Combination c = new Combination();
        c.setTitle("1-11");
         Integer a = 10 ;
        a=  buildInteger(a,c);
        System.out.println(a);
        System.out.println(c.getTitle());
    }

    private Integer buildInteger(Integer a,Combination c ) {
        a= 100;
        c.setTitle("213123");
        return a ;
    }


    @org.junit.Test
    public void test1() throws Exception {
        for (int i = 0; i < 100; i++) {
            URL defaultUrl = new URL("https://cp-asset.amwaynet.com.cn/course-compose/1648730912245.png");
            HttpURLConnection httpURLConnection = (HttpURLConnection) defaultUrl.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            try (InputStream inputStream =  httpURLConnection.getInputStream()) {
                BufferedImage image = ImageIO.read(inputStream);
                System.out.println("image成功");
            }catch (Exception ex){
                System.out.println(ex.getStackTrace());
            }
        }
    }

    @org.junit.Test
    public void test(){

        String mgStr ="中药,"+
                "中枢神经,"+
                "中国体育代表团,"+
                "中草药,"+
                "有机,"+
                "优秀,"+
                "运气,"+
                "王牌,"+
                "绝对,"+
                "第一,"+
                "卓越,"+
                "CA,"+
                "SP,"+
                "最有效,"+
                "最优,"+
                "最养生,"+
                "最新科学,"+
                "最新,"+
                "最先,"+
                "最具,"+
                "最后,"+
                "最好,"+
                "最低,"+
                "最大,"+
                "最爱,"+
                "助眠,"+
                "重生,"+
                "重金属,"+
                "终极,"+
                "整形,"+
                "镇定,"+
                "诊断,"+
                "益智,"+
                "医治,"+
                "医疗,"+
                "药方,"+
                "延年益寿,"+
                "延缓更年期,"+
                "消化不良,"+
                "消毒,"+
                "无添加,"+
                "无敌,"+
                "胃痛,"+
                "唯一,"+
                "头痛,"+
                "天然,"+
                "特效,"+
                "特级,"+
                "瘦身,"+
                "首选,"+
                "世界级,"+
                "世界第一,"+
                "失眠,"+
                "生发,"+
                "奢侈,"+
                "烧伤,"+
                "伤风感冒,"+
                "杀菌,"+
                "色斑,"+
                "妊娠斑,"+
                "全面,"+
                "全方位,"+
                "清除,"+
                "强壮,"+
                "平皱,"+
                "毛细血管,"+
                "绿色,"+
                "领导品牌,"+
                "淋巴液,"+
                "抗菌,"+
                "抗癌,"+
                "解读,"+
                "解毒,"+
                "脚气,"+
                "减体重,"+
                "减肥,"+
                "极致,"+
                "极效,"+
                "极速,"+
                "激活,"+
                "环保,"+
                "护士,"+
                "荷尔蒙,"+
                "汉方,"+
                "国家级,"+
                "独一无二,"+
                "冻伤,"+
                "顶级,"+
                "大夫,"+
                "痤疮,"+
                "彻底,"+
                "超强,"+
                "补血,"+
                "补肾,"+
                "便秘,"+
                "疤痕,"+
                "奥运,"+
                "安神,"+
                "安全,"+
                "关节痛,"+
                "高效,"+
                "肝硬化,"+
                "改善睡眠,"+
                "改善记忆,"+
                "腹泻,"+
                "腹痛,"+
                "复方,"+
                "分钟,"+
                "防癌,"+
                "最";

                String wjStr = "皇冠,"+
                        "最科学,"+
                        "延缓衰老,"+
                        "皮炎,"+
                        "皮肤病,"+
                        "牛皮癣,"+
                        "疗效,"+
                        "抗血栓,"+
                        "丰胸,"+
                        "防治高血压,"+
                        "防治,"+
                        "百分百,"+
                        "支气管炎,"+
                        "最佳,"+
                        "抗炎,"+
                        "疾病,"+
                        "最高级,"+
                        "永久,"+
                        "消炎,"+
                        "脑血栓,"+
                        "治愈,"+
                        "哮喘,"+
                        "免疫力,"+
                        "古方,"+
                        "基因,"+
                        "抗生素,"+
                        "消除,"+
                        "治疗,"+
                        "处方,"+
                        "药物,"+
                        "细菌,"+
                        "最高,"+
                        "医生,"+
                        "激素,"+
                        "临床,"+
                        "新生,"+
                        "完全,"+
                        "肿瘤,"+
                        "抗氧化,"+
                        "中国驰名,"+
                        "真菌,"+
                        "珍稀,"+
                        "万能,"+
                        "贝瑞德,"+
                        "耶格,"+
                        "环宇,"+
                        "寰宇,"+
                        "成冠,"+
                        "超凡,"+
                        "耀升,"+
                        "3S群星,"+
                        "Chaofan/CHAOFAN,"+
                        "Ultra,"+
                        "Crador/CARDOR,"+
                        "HUANYU,"+
                        "Excellence Network,"+
                        "N21,"+
                        "Bill Britt,"+
                        "Yager,"+
                        "Network21,"+
                        "铜章,"+
                        "银章,"+
                        "金章,"+
                        "直系,"+
                        "红宝石,"+
                        "明珠,"+
                        "蓝宝石,"+
                        "翡翠,"+
                        "钻石,"+
                        "行政钻石,"+
                        "双钻石,"+
                        "三钻石,"+
                        "皇冠大使,"+
                        "Bronze,"+
                        "GP,"+
                        "DD,"+
                        "ruby,"+
                        "pearl,"+
                        "sapphire,"+
                        "emerald,"+
                        "diamond,"+
                        "EDC,"+
                        "Double diamond,"+
                        "Triple diamond,"+
                        "crown,"+
                        "Crown Ambassador,"+
                        "最赚,"+
                        "最优秀,"+
                        "最营养,"+
                        "最新技术,"+
                        "最新发明,"+
                        "最新创造,"+
                        "最先享受,"+
                        "最先进科学,"+
                        "最先进,"+
                        "最舒适,"+
                        "最受欢迎,"+
                        "最奢侈,"+
                        "最流行,"+
                        "最后一波,"+
                        "最好吃,"+
                        "最高科学,"+
                        "最高端,"+
                        "最符合,"+
                        "最顶尖,"+
                        "最低价,"+
                        "最低级,"+
                        "最便宜,"+
                        "祖方,"+
                        "祖传秘方,"+
                        "祖传,"+
                        "阻断黑色素,"+
                        "阻碍黑色素,"+
                        "滋阴补阳,"+
                        "卓效,"+
                        "壮阳,"+
                        "逐层减退多种色斑,"+
                        "周期见效,"+
                        "中医世家,"+
                        "治失眠,"+
                        "质量免检,"+
                        "至尊,"+
                        "止脱,"+
                        "止咳,"+
                        "脂溢性脱发,"+
                        "整肤,"+
                        "镇静,"+
                        "招财进宝,"+
                        "永保青春,"+
                        "益气,"+
                        "抑制黑色素,"+
                        "抑菌,"+
                        "一洗白,"+
                        "药妆,"+
                        "药用,"+
                        "药物制剂,"+
                        "养颜美容,"+
                        "养脑,"+
                        "厌氧菌,"+
                        "牙孢菌,"+
                        "雄性激素,"+
                        "小分子团水,"+
                        "销售冠军,"+
                        "销量第一,"+
                        "消除心律不整,"+
                        "消除斑点,"+
                        "细胞增殖和分化,"+
                        "细胞再生,"+
                        "细胞提取液,"+
                        "吸脂,"+
                        "吸附铅汞,"+
                        "吸附并排除各种对人体有害的毒素，如铵盐,"+
                        "无着色,"+
                        "无依赖,"+
                        "无需国家质量检测,"+
                        "无需保持健康合理膳食和运动等规律生活习惯，可达到快速减脂,"+
                        "无效退款,"+
                        "无香精,"+
                        "无添加铅汞坤,"+
                        "无添加矿油配方,"+
                        "无任何副作用,"+
                        "无酒精添加,"+
                        "无硅油,"+
                        "无硅,"+
                        "无副作用,"+
                        "无毒副作用,"+
                        "无毒,"+
                        "无斑,"+
                        "无胺,"+
                        "温和不刺激,"+
                        "胃胀蠕动,"+
                        "胃肠蠕动,"+
                        "微整,"+
                        "微米,"+
                        "旺财,"+
                        "脱敏,"+
                        "褪敏,"+
                        "头癣,"+
                        "头昏头晕,"+
                        "通脉,"+
                        "通便,"+
                        "调整人体内分泌平衡,"+
                        "调节体内酸碱度，恢复身体机能,"+
                        "调节内分泌失调,"+
                        "调节内分泌,"+
                        "调节肠道菌群,"+
                        "填补国内空白,"+
                        "天然零负担,"+
                        "天然精纯,"+
                        "天见效,"+
                        "体癣,"+
                        "特速,"+
                        "烫伤,"+
                        "胎盘提取液,"+
                        "酸性水,"+
                        "速效,"+
                        "速白,"+
                        "舒敏,"+
                        "舒眠,"+
                        "瘦腿,"+
                        "瘦脸,"+
                        "首家,"+
                        "首个,"+
                        "首创,"+
                        "手癣,"+
                        "事业运,"+
                        "世界领先,"+
                        "世界杯,"+
                        "使乳房丰满,"+
                        "史无前例,"+
                        "史上最低价,"+
                        "时来运转,"+
                        "生肌肉,"+
                        "生黑发,"+
                        "神效,"+
                        "神经损害,"+
                        "神丹,"+
                        "伤口愈合清除毒素,"+
                        "润燥,"+
                        "柔敏,"+
                        "溶脂,"+
                        "妊娠纹,"+
                        "妊辰纹,"+
                        "燃烧脂肪,"+
                        "全效,"+
                        "全网第一,"+
                        "全秃,"+
                        "全球首发,"+
                        "全国首次,"+
                        "全国第一,"+
                        "去除皱纹,"+
                        "去除体内毒素,"+
                        "祛瘀,"+
                        "祛痰止喘,"+
                        "祛黄褐斑,"+
                        "祛寒解毒,"+
                        "祛风,"+
                        "祛痤疮,"+
                        "祛除皱纹,"+
                        "祛除雀斑,"+
                        "祛疤,"+
                        "驱寒解毒,"+
                        "丘疹,"+
                        "清咽,"+
                        "清热祛湿,"+
                        "清热解毒,"+
                        "清除黑头,"+
                        "青光眼,"+
                        "强效,"+
                        "强力,"+
                        "强精,"+
                        "前无古人,"+
                        "奇效,"+
                        "奇速,"+
                        "破坏黑色素细胞,"+
                        "平衡荷尔蒙,"+
                        "皮康霜,"+
                        "皮肤细胞间的氧气交换,"+
                        "皮肤面部痉挛等疾病名称或症状,"+
                        "皮肤感染,"+
                        "皮肤变态反应,"+
                        "排名第一,"+
                        "脓疱,"+
                        "念珠菌,"+
                        "能量水,"+
                        "纳米级,"+
                        "纳米,"+
                        "名牌,"+
                        "灭菌,"+
                        "免抽检,"+
                        "秘制,"+
                        "美容治疗,"+
                        "毛囊炎,"+
                        "毛囊寄生虫等微生物名称,"+
                        "毛囊激活,"+
                        "毛发再生,"+
                        "毛发新生,"+
                        "霾毒,"+
                        "滤净率,"+
                        "六大无添加,"+
                        "领袖品牌,"+
                        "零敏,"+
                        "淋巴毒,"+
                        "临床观察具有明显效果,"+
                        "利尿,"+
                        "理气,"+
                        "抗雾霾,"+
                        "抗手机,"+
                        "抗皮肤衰老,"+
                        "抗敏,"+
                        "抗动脉粥样硬化,"+
                        "糠秕孢子菌,"+
                        "军旗,"+
                        "绝无仅有,"+
                        "绝佳,"+
                        "巨星,"+
                        "酒糟鼻,"+
                        "酒前,"+
                        "酒后服用解酒,"+
                        "精确,"+
                        "经痛,"+
                        "经皮肤测试,"+
                        "仅此一款,"+
                        "仅此一次,"+
                        "金牌,"+
                        "脚癣,"+
                        "健康富贵,"+
                        "碱性水,"+
                        "减少红血丝,"+
                        "减轻或缓解疾病症状,"+
                        "减轻或缓解疾病症,"+
                        "减轻过敏性皮肤病,"+
                        "甲癣,"+
                        "极易被吸收,"+
                        "极品,"+
                        "极佳,"+
                        "肌痛,"+
                        "活血,"+
                        "活化水,"+
                        "恢复视力,"+
                        "黄褐斑,"+
                        "患处,"+
                        "换肤,"+
                        "缓敏,"+
                        "缓解烟毒,"+
                        "缓解体力疲劳,"+
                        "缓解视疲劳,"+
                        "缓解脑力疲劳,"+
                        "缓解痉挛抽搐,"+
                        "缓解大脑衰老,"+
                        "化解小人,"+
                        "化解死细胞,"+
                        "花斑癣,"+
                        "蝴蝶斑,"+
                        "红肿,"+
                        "行气,"+
                        "国旗,"+
                        "国家统计局,"+
                        "国家体育局,"+
                        "国家免检,"+
                        "国家级第一品牌,"+
                        "国家级产品,"+
                        "国家环境保护部,"+
                        "国家海洋局级地考察办公室,"+
                        "冠军级,"+
                        "冠级,"+
                        "股癣,"+
                        "宫廷,"+
                        "功能水,"+
                        "更新肌肤,"+
                        "各种疾病名称,"+
                        "各类皮肤病名称,"+
                        "高智力,"+
                        "干细胞,"+
                        "改善营养性贫血,"+
                        "改善食欲,"+
                        "改善生长发育,"+
                        "改善皮肤油份,"+
                        "改善皮肤水份,"+
                        "改善内分泌,"+
                        "改善敏感肌肤,"+
                        "改善缓解脑力疲劳,"+
                        "改善喉咙发炎,"+
                        "改善过敏现象,"+
                        "改善过敏体质,"+
                        "改善各种面部肌肤问题,"+
                        "富氧水,"+
                        "复活,"+
                        "辅助戒烟,"+
                        "辅助降血脂,"+
                        "辅助降血压,"+
                        "辅助降血糖,"+
                        "辅助改善记忆,"+
                        "肤螨灵,"+
                        "肤乐霜,"+
                        "丰乳,"+
                        "非转基因,"+
                        "防止血液凝固,"+
                        "防止贫血,"+
                        "防止卵巢及子宫的功能紊乱,"+
                        "防止高血压,"+
                        "防止便秘,"+
                        "防敏,"+
                        "防菌,"+
                        "鹅掌癣,"+
                        "对胃粘膜损伤有辅助保护功能,"+
                        "对所有程度的胃黏膜损伤均有保护功能,"+
                        "对抗自由基侵害，排毒养颜,"+
                        "对疾病引起的咽喉肿痛有治疗效果,"+
                        "对化学性肝损伤的辅助保护作用,"+
                        "对辐射危害有辅助保护功能,"+
                        "对放化疗有辅助作用,"+
                        "度假,"+
                        "独家,"+
                        "冻疮,"+
                        "顶尖,"+
                        "顶级享受,"+
                        "顶级工艺,"+
                        "电脑等电磁辐射,"+
                        "第一品牌,"+
                        "第六感,"+
                        "刀伤,"+
                        "雌性激素,"+
                        "纯植物,"+
                        "纯天然,"+
                        "疮痈,"+
                        "传染性湿疹,"+
                        "除湿,"+
                        "除菌,"+
                        "彻底清除,"+
                        "超赚,"+
                        "采用新型着色机理永不褪色,"+
                        "不添加防腐剂,"+
                        "补氧,"+
                        "病变性脱发,"+
                        "表皮生长因子,"+
                        "保险公司承保,"+
                        "保护心肌细胞,"+
                        "保护记忆力,"+
                        "保持皮肤光泽,"+
                        "斑立净,"+
                        "百医,"+
                        "百草,"+
                        "奥林匹克,"+
                        "暗黄,"+
                        "Top1,"+
                        "No.1,"+
                        "FIFA,"+
                        "EGF,"+
                        "DNA再生";


        String redStr ="传销,"+
                "自然疗法,"+
                "纽崔莱不用吃药,"+
                "纽崔莱不用看病,"+
                "纽崔莱不用看医生,"+
                "安利治疗,"+
                "纽崔莱治疗,"+
                "安利治愈,"+
                "纽崔莱治愈,"+
                "安利治病,"+
                "纽崔莱治病,"+
                "安利诊疗,"+
                "纽崔莱诊疗,"+
                "安利诊断,"+
                "纽崔莱诊断,"+
                "安利医疗,"+
                "纽崔莱医疗,"+
                "安利处方,"+
                "纽崔莱处方,"+
                "安利多层次,"+
                "安利奖金制度,"+
                "安利计酬方式,"+
                "安利业务计划,"+
                "九种十二项,"+
                "世袭奖金,"+
                "团队奖金,"+
                "开处方,"+
                "咖啡灌肠,"+
                "治疗脂肪肝,"+
                "治疗运动缺氧,"+
                "治疗阴臭,"+
                "治疗因辐射造成的损伤,"+
                "治疗腋臭,"+
                "治疗胃胀,"+
                "治疗胃部疾病,"+
                "治疗体臭,"+
                "治疗乳房胀痛炎症,"+
                "治疗脑缺氧,"+
                "治疗慢性咽炎,"+
                "治疗近视,"+
                "治疗化学性肝损伤,"+
                "治疗骨损伤,"+
                "治疗肠道功能紊乱,"+
                "治疗便秘,"+
                "治疗斑秃,"+
                "治疗白内障,"+
                "以替代胰岛素等降糖类药物,"+
                "增强皮下组织新陈代谢,"+
                "御制,"+
                "预防治疗心脑血管等疾病,"+
                "预防长痘,"+
                "预防因疾病引起的身体疲劳,"+
                "预防乳房松弛下垂,"+
                "预防脑溢血,"+
                "预防或治疗糖尿病,"+
                "预防和治疗白内障,"+
                "预防改善老年痴呆症,"+
                "预防便秘,"+
                "有效抑制并淡化黑色素,"+
                "优化细胞结构,"+
                "迅速修复受紫外线伤害的肌肤,"+
                "修护受损肌肤,"+
                "修复受损肌肤,"+
                "修复断裂弹性纤维,"+
                "修复断裂弹力纤维,"+
                "提高学习专注力,"+
                "提高性功能,"+
                "提高缺氧耐受力,"+
                "提高考试成绩,"+
                "提高记忆或学习专注力,"+
                "提高肌肤自身养护能力,"+
                "提高肌肤抗刺激,"+
                "塑形效果，体重不反弹,"+
                "可完全替代正常饮食,"+
                "可替代安眠药快速入睡,"+
                "可缓解因心脑血管系统障碍或呼吸系统障碍导致的供氧不足,"+
                "可根除黄褐斑,"+
                "降低血液黏度,"+
                "降低肌肤敏感度,"+
                "促进血液循环及消除疲劳,"+
                "促进新陈代谢,"+
                "促进睡眠,"+
                "促进排铅,"+
                "促进泌乳,"+
                "促进二次发育,"+
                "上线,"+
                "下线,"+
                "断食,"+
                "治疗肿瘤,"+
                "治疗高血压,"+
                "增强免疫力,"+
                "增加骨密度,"+
                "增高,"+
                "再生,"+
                "促进消化,"+
                "愈合,"+
                "排毒,"+
                "预防疾病,"+
                "预防老年痴呆,"+
                "提高记忆力,"+
                "降血压"
                ;

        String[] mgStrSplit = mgStr.split("、");

        String[] wjSplit = wjStr.split(",");
        String[] redSplit = redStr.split(",");


        List<CourseStorage> courseStorages =
                courseStorageMapper.selectList();

        for (CourseStorage courseStorage : courseStorages) {
            String haveMg = "";
            for (String mg : mgStrSplit) {
                if((courseStorage.getOverview().contains(mg)||courseStorage.getTitle().equals(mg))
                && !haveMg.contains(mg) ){
                    haveMg = haveMg +mg +",";
                }
            }
            String haveWj = "";
            for (String wj : wjSplit) {
                if((courseStorage.getOverview().contains(wj)||courseStorage.getTitle().equals(wj))
                        && !haveWj.contains(wj)){
                    haveWj = haveWj +wj +",";
                }
            }

            String haveRed = "";
            for (String red : redSplit) {
                if((courseStorage.getOverview().contains(red)||courseStorage.getTitle().equals(red))
                        && !haveRed.contains(red)){
                    haveRed = haveRed +red +",";
                }
            }

            courseStorageMapper.updateById(courseStorage.getId(),haveMg,haveWj,haveRed);
        }

        List<Combination> combinations =
                combinationMapper.selectList();

        for (Combination combination : combinations) {
            String haveMg = "";
            for (String mg : mgStrSplit) {
                if(Objects.isNull(mg)){
                    break;
                }
                if(((Objects.nonNull(combination.getDescription()) && combination.getDescription().contains(mg))||
                (Objects.nonNull(combination.getTitle()) && combination.getTitle().contains(mg))||
                (Objects.nonNull(combination.getRule()) && combination.getRule().contains(mg)))
                        && !haveMg.contains(mg)){
                    haveMg = haveMg +mg +",";
                }
            }
            String haveWj = "";
            for (String wj : wjSplit) {
                if(Objects.isNull(wj)){
                    break;
                }
                if(((Objects.nonNull(combination.getDescription()) && combination.getDescription().contains(wj))||
                        (Objects.nonNull(combination.getTitle()) && combination.getTitle().contains(wj))||
                        (Objects.nonNull(combination.getRule()) && combination.getRule().contains(wj)))
                                && !haveWj.contains(wj)){
                    haveWj = haveWj +wj +",";
                }
            }

            String haveRed = "";
            for (String red : redSplit) {
                if(Objects.isNull(red)){
                    break;
                }
                if(((Objects.nonNull(combination.getDescription()) && combination.getDescription().contains(red))||
                        (Objects.nonNull(combination.getTitle()) && combination.getTitle().contains(red))||
                        (Objects.nonNull(combination.getRule()) && combination.getRule().contains(red)))
                        && !haveWj.contains(red)){
                    haveRed = haveRed +red +",";
                }
            }
            combinationMapper.updateById(combination.getId(),haveMg,haveWj,haveRed);
        }
    }
}
