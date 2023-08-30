import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {
    @Resource(mappedName = "jms/myMsgDest")
    private Queue myMsgDest;
    
    @Resource(mappedName = "jms/myMsg")
    private ConnectionFactory connectionFactory;

    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String str = request.getParameter("txtMsg");
        PrintWriter pw = response.getWriter();
        pw.println("<h1>Your messsage is sent</h1>");
        sendJMSMessageToMyMsgDest(str);
    }

    private void sendJMSMessageToMyMsgDest(String messageData) {
        Connection connection;
        try{
            connection = connectionFactory.createConnection();
            Session session = connection.createSession();
            MessageProducer msgProducer = session.createProducer(myMsgDest);
        
            TextMessage tm = session.createTextMessage();
            tm.setText(messageData);
            
            msgProducer.send(tm);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
