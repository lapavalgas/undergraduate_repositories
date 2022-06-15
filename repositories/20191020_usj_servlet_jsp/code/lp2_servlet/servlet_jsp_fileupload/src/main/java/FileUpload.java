
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());

		List<FileItem> multifiles;

		try {

			multifiles = sf.parseRequest(request);

			for (FileItem item : multifiles) {
				item.write(new File(
						"D:\\Workspace\\.studies\\ADS.2019.2.LP2.SpringDataJPA\\servletfile\\files\\" + item.getName()));
				System.out.println(item.getName() + "|| file  uploaded ||");

			}

		} catch (FileUploadException e) {
			System.out.println(e);
			e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		

		/***
		 * Example:
		 *	// Create a factory for disk-based file items
		*	factory = new DiskFileItemFactory();
*
*			Create a new file upload handler
*			upload = new ServletFileUpload(factory);
*
*			Parse the request
*			FileItem items = upload.parseRequest(request);
*		*/
	}
}