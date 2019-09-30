//package cn.cw;
//
//import cn.cw.util.ExcelMake;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ApplicationTest {
//
//
//    @Test
//    public void contextLoads() {
//
//            System.out.println(Integer.valueOf(""));
////
////        System.out.println(AESUtil.encrypt("Cps","123456789"));
////        System.out.println(AESUtil.decrypt("kaqkY/pR6B9+q5t08Qe+HQ==","123456789"));
//
////        System.out.println(MD5.getMD5String("_Cps"));
////        System.out.println(StringUtil.getNewOrderNo());
//
////        System.out.println(BirthUtil.getSex("410526199912120119"));
////        System.out.println(BirthUtil.getZodica("410526199912120119"));
////        System.out.println(BirthUtil.getConstellation("410526199912120119"));
//
//            ExcelMake make = new ExcelMake("报表导出");
//            make.createRow();
//            make.createCell(26,1).setCellValue("_Cps");
//            make.createRow();
//            make.createCell(1,4).setCellValue("序号");
//            make.createCell(1,4).setCellValue("部门");
//            make.createCell(1,4).setCellValue("姓名");
//            make.createCell(6,2).setCellValue("应发项目");
//            make.createCell(13, 1).setCellValue("应扣项目");
//            for(int i=0;i<4;i++){
//                make.createCell();
//            }
//
//            make.createRow();
//            make.createCell(1, 2).setCellValue("住房补贴");
//            make.createCell(2, 2).setCellValue("公积金");
//            make.createCell(10, 1).setCellValue("社保");
//            make.createCell(1, 3).setCellValue("个人所得税");
//            make.createCell(1, 3).setCellValue("请假扣款");
//            make.createCell(1, 3).setCellValue("用工总成本");
//            make.createCell(1, 3).setCellValue("入工资卡费用合计");
//
//            make.createRow();
//            make.createCell(1, 2).setCellValue("基本工资");
//            make.createCell(1, 2).setCellValue("岗位工资");
//            make.createCell(1, 2).setCellValue("业务补贴");
//            make.createCell(1, 2).setCellValue("健康补贴");
//            make.createCell(1, 2).setCellValue("年功工资");
//            make.createCell(1, 2).setCellValue("合计");
//
//            make.createCell(2, 1).setCellValue("养老");
//            make.createCell(2, 1).setCellValue("医疗");
//            make.createCell(2, 1).setCellValue("失业");
//            make.createCell(2, 1).setCellValue("生育");
//            make.createCell(2, 1).setCellValue("工伤");
//
//            make.createRow();
//            make.createCell().setCellValue("公司");
//
//            make.createCell().setCellValue("公司");
//            make.createCell().setCellValue("个人");
//            make.createCell().setCellValue("公司");
//            make.createCell().setCellValue("个人");
//            make.createCell().setCellValue("公司");
//            make.createCell().setCellValue("个人");
//            make.createCell().setCellValue("公司");
//            make.createCell().setCellValue("个人");
//            make.createCell().setCellValue("公司");
//            make.createCell().setCellValue("个人");
//            make.createCell().setCellValue("公司");
//            make.createCell().setCellValue("个人");
//
//            HSSFWorkbook hssfWorkbook = make.getHssfWorkbook();
//            FileOutputStream stream = null;
//            try {
//                File file = new File("D:/","xx.xls");
//                stream = new FileOutputStream(file);
//                file.deleteOnExit();
//                hssfWorkbook.write(stream);
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//        @Test
//        public void testV4IP(){
//           System.out.println(getV4IP());
//        }
//
//        /**
//         * 获取本机的外网ip地址
//         * @return
//         */
//        public String getV4IP(){
//                String ip = "";
//                String chinaz = "http://ip.chinaz.com";
//                StringBuilder inputLine = new StringBuilder();
//                String read = "";
//                URL url = null;
//                HttpURLConnection urlConnection = null;
//                BufferedReader in = null;
//                try {
//                        url = new URL(chinaz);
//                        urlConnection = (HttpURLConnection) url.openConnection();
//                        in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
//                        while((read=in.readLine())!=null){
//                                inputLine.append(read+"\r\n");
//                        }
////System.out.println(inputLine.toString());
//                } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                } catch (IOException e) {
//                        e.printStackTrace();
//                }finally{
//                        if(in!=null){
//                                try {
//                                        in.close();
//                                } catch (IOException e) {
//// TODO Auto-generated catch block
//                                        e.printStackTrace();
//                                }
//                        }
//                }
//                Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
//                Matcher m = p.matcher(inputLine.toString());
//                if(m.find()){
//                        String ipstr = m.group(1);
//                        ip = ipstr;
////System.out.println(ipstr);
//                }
//                return ip;
//        }
//
//        @Test
//        public void testYinYongChuanDi(){
//                Integer num = 0;
//                printNum(num);
//                System.out.println(num);
//        }
//
//        public void printNum(Integer num){
//                num++;
//                System.out.println(num);
//        }
//}
//
