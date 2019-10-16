
import java.awt.event.*;
public class Controller {

    private View view;
    private Model model;
    private ActionListener actionListener;

    public Controller(){
        this.view=new View();
        this.model=new Model();

    }
    public void control(){
        System.out.println("i'm here debug1");
        view.getNewfile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("i'm here debug 2 ");
                view.Openfile();
            }
        });
    }



}
