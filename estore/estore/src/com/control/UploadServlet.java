package com.control;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.MerDAOImp;
import com.entity.Merchandise;
import com.my.util.Exchanger;

@WebServlet(urlPatterns="/UploadServlet",name="UploadServlet")
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String filePath; // 鏂囦欢瀛樻斁鐩綍
    private String tempPath; // 涓存椂鏂囦欢鐩綍
	 private String filename ;
    private String SQLFileName;
    private int gid;
	private int category;
	private String mername;
	private double price;
	private double sprice;
	private String picture;
	private String merdesc;
	private String manufacturer;
	private int special;

    // 鍒濆鍖�
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // 鍙互浠庨厤缃枃浠朵腑鑾峰緱鍒濆鍖栧弬鏁�
        //filePath = config.getInitParameter("filepath");
        //tempPath = config.getInitParameter("temppath");
        //ServletContext context = getServletContext();
        //filePath = context.getRealPath(filePath);
        //tempPath = context.getRealPath(tempPath);
        filePath="/background/sp";
        tempPath="/temp";
    }

    // doPost
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        try {
            DiskFileItemFactory diskFactory = new DiskFileItemFactory();
            // threshold 鏋侀檺銆佷复鐣屽�硷紝鍗崇‖鐩樼紦瀛� 1M
            diskFactory.setSizeThreshold(10 * 1024);
            // repository 璐棌瀹わ紝鍗充复鏃舵枃浠剁洰褰�
            diskFactory.setRepository(new File(tempPath));

            ServletFileUpload upload = new ServletFileUpload(diskFactory);
            //闃叉涔辩爜
            upload.setHeaderEncoding("UTF-8");
            // 璁剧疆鍏佽涓婁紶鐨勬渶澶ф枃浠跺ぇ灏� 4M
            upload.setSizeMax(10 * 1024 * 1024);
            // 瑙ｆ瀽HTTP璇锋眰娑堟伅澶�
            List<FileItem> fileItems = upload.parseRequest(request);
            Iterator<FileItem> iter = fileItems.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
//                    processFormField(item, pw);//澶勭悊琛ㄥ崟鍐呭
                } else {
                    processUploadFile(item, pw);//澶勭悊涓婁紶鐨勬枃浠�

                }
            }

            SQLFileName=tempPath+"/"+filename;
           //鏁版嵁杩涘叆鏁版嵁搴�
            String mername=request.getParameter("mername");
 		   mername=Exchanger.exchange(mername);
 		   String categorystr=request.getParameter("category");
 		   categorystr=Exchanger.exchange(categorystr);
 		   int category=0;
 		   if(categorystr.equals("椋熷搧")){
 			    category=1;
 		   }else if(categorystr.equals("鍖栧鍝�")){
 			   category=2;
 		   }else if(categorystr.equals("瀹剁數")){
 			   category=3;
 		   }else if(categorystr.equals("鏂囧叿")){
 			   category=4;
 		   }else{
 			   category=5;
 		   }
 		   String pricestr=request.getParameter("price");
 		   pricestr=Exchanger.exchange(pricestr);
 		   double price=0;
 		   if(pricestr!=null){
 			   price=Double.parseDouble(pricestr);
 		   }
 		   String spricestr=request.getParameter("sprice");
 		   spricestr=Exchanger.exchange(spricestr);
 		   double sprice=0;
 		   if(spricestr!=null){
 			   sprice=Double.parseDouble(spricestr);
 		   }
 		   String picture=request.getParameter("picture");
 		   picture=Exchanger.exchange(picture);
 		   String merdesc=request.getParameter("merdesc");
 		   merdesc=Exchanger.exchange(merdesc);
 		   String manufacturer=request.getParameter("manufacturer");
 		   manufacturer=Exchanger.exchange(manufacturer);
 		   String specialstr=request.getParameter("special");
 		   specialstr=Exchanger.exchange(specialstr);
 		   int special=0;
 		   if(specialstr!=null){
 			   special=Integer.parseInt(specialstr);
 		   }
 		   Merchandise mer=new Merchandise();
 		   mer.setCategory(category);
 		   mer.setManufacturer(manufacturer);
 		   mer.setMername(mername);
 		   mer.setPicture(picture);
 		   mer.setPrice(price);
 		   mer.setSprice(sprice);
 		   mer.setSpecial(special);
 		   mer.setMerdesc(merdesc);
 		   MerDAOImp mdi=new MerDAOImp();
 		   mdi.insert(mer);
            pw.close();

        } catch (Exception e) {
            System.out.println("寮傚父锛氫娇鐢� fileupload 鍖呭彂鐢熷紓甯�!");
            e.printStackTrace();
        }
        
        RequestDispatcher rd =request.getRequestDispatcher("/MerServlet");
        try{
            rd.forward(request, response);
            return;
        }catch(Exception e){
            System.out.print(e.toString());
        }
        return;
    }

//    // 澶勭悊琛ㄥ崟鍐呭
//    private void processFormField(FileItem item, PrintWriter pw)
//            throws Exception {
//        String name = item.getFieldName();
//        if(name.equals("stuid")){
//            studentid = item.getString();
//        }else if(name.equals("workid")){
//            workid = item.getString();
//        }
//    }

    // 澶勭悊涓婁紶鐨勬枃浠�
    private void processUploadFile(FileItem item, PrintWriter pw)
            throws Exception {
        filename = item.getName();
        int index = filename.lastIndexOf("\\");
        filename = filename.substring(index + 1, filename.length());
        long fileSize = item.getSize();
        if ("".equals(filename) && fileSize == 0) {
            System.out.println("鏂囦欢鍚嶄负绌� !");
            return;
        }
        File mu1=new File(filePath);
        File mu2=new File(tempPath);
        if(!mu1.exists())
        {
        	mu1.mkdirs();
        }
        if(!mu2.exists())
        {
        	mu2.mkdirs();
        }
        File uploadFile = new File(filePath + "/" + filename);
        if(!uploadFile.exists())
        {
        	System.out.println("鏂囦欢涓嶅瓨鍦�");
        }else{
        item.write(uploadFile);
        }
    }

    // doGet
    public void doGet(HttpServletRequest request, HttpServletResponse res)
            throws IOException, ServletException {
        doPost(request, res);
    }
}
