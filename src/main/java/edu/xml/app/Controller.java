
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

        view.getOpenfile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                view.Openfile();
            }
        });
        view.getEnd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.quitter();
            }
        });

    }



}
