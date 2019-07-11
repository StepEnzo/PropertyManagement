package AdminServlet;

import org.apache.commons.lang3.StringUtils;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "PrintBarcodeServlet")
public class PrintBarcodeServlet extends HttpServlet {
    public PrintBarcodeServlet(){};
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String id=request.getParameter("id");
        String find=request.getParameter("guanjianci");
//        String id="123456";
        PrintBarcodeServlet printBarcode=new PrintBarcodeServlet();
        String msg = id;
        String path = "D:\\pillar\\"+id+".jpg";
        printBarcode.getBarCode(msg,path);
        out.println("<script language='javascript'>alert('打印成功!');</script>");
        request.getRequestDispatcher("./FindProperty.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    public void getBarCode(String msg,String path){
        try {
            File file=new File(path);
            OutputStream ous=new FileOutputStream(file);
            if(StringUtils.isEmpty(msg) || ous==null)
                return;
            //选择条形码类型(好多类型可供选择)
            Code128Bean bean=new Code128Bean();
            //设置长宽
            final double moduleWidth=0.20;
            final int resolution=150;
            bean.setModuleWidth(moduleWidth);
            bean.doQuietZone(false);
            String format = "image/png";
            // 输出流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(ous, format,
                    resolution, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            //生成条码
            bean.generateBarcode(canvas,msg);
            canvas.finish();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
