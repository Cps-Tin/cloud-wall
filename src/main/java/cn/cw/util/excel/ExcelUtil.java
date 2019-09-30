package cn.cw.util.excel;

import cn.cw.util.FileUtil;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    /**
     *  导入Excel(xlsx版本)
     * @param inputStream
     * @param tClass
     * @param <T>
     * @return
     */
    public static  <T> List<T> ImportExcel(InputStream inputStream,  Class<? extends BaseRowModel>  tClass){
        //实例化实现了AnalysisEventListener接口的类
        ExcelListener listener = new ExcelListener();
        //传入参数
        //ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
        ExcelReader excelReader = EasyExcelFactory.getReader(inputStream,listener);
        //读取信息
        excelReader.read(new Sheet(1, 1, tClass));

        //获取数据
        List<Object> list = listener.getDatas();

        //封装成泛型返回值
        List<T> listReturn = new ArrayList<T>();
        for (int i = 0; i < list.size(); i++) {
            T classObj = (T) list.get(i);
            listReturn.add(classObj);
        }
        return listReturn;
    }

    /**
     *  导出Excel(xlsx版本)
     * @param fileName
     * @param response
     * @param data
     * @param clazz
     * @throws IOException
     */
    public static void ExportExcel(String fileName, HttpServletResponse response, List<? extends BaseRowModel> data, Class<? extends BaseRowModel> clazz) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        FileUtil.setResponseHeader(fileName+".xlsx",response);
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        Sheet sheet1 = new Sheet(1, 0, clazz);

//        sheet1.setSheetName("第一个sheet");
        writer.write(data, sheet1);
        writer.finish();

        out.flush();
    }
}
