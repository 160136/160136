/*
    Nguyen Anh Quang
    160137
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Quiz {
    public static void main(String[] args) {
        QuizForm app = new QuizForm();
    }
}

class QuizForm
{
    JFrame frame;
    JLabel lbQuestion;
    JLabel lbMessage;
    JTextField txtAnswer;
    JButton btnCheck;
    JButton btnNext;
    int idx = 0;
    int score = 0;
    String[] listQuestions;
    Question q;

    public QuizForm()
    {
        init_questions();
        String question = nextQuestion();
        int width = 200;
        int height = 300;
        frame = new JFrame("Picture Change");
        frame.setLocation(300, 300);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel pnQuestion = new JPanel();
        lbQuestion = new JLabel(question, SwingConstants.CENTER);
        lbQuestion.setPreferredSize( new Dimension( width, height/4 ) );
        pnQuestion.add(lbQuestion);

        JPanel pnText = new JPanel();
        txtAnswer = new JTextField();
        txtAnswer.setPreferredSize( new Dimension( width, 20 ) );
        pnText.add(txtAnswer);

        JPanel pnMessage = new JPanel();
        lbMessage = new JLabel("", SwingConstants.CENTER);
        pnMessage.add(lbMessage);

        JPanel pnButton = new JPanel();
        btnCheck = new JButton("チェック");
        pnButton.add(btnCheck);
        btnNext = new JButton("次");
        btnNext.setVisible(false);
        pnButton.add(btnNext);



        ActionListener saveActionListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                System.out.println("action");
                boolean flag = checkQuestion(txtAnswer.getText());
                if (flag)
                {
                    btnCheck.setVisible(false);
                    lbMessage.setText("◯　正しい");
                    btnNext.setVisible(true);
                }
                else
                {
                    lbMessage.setText("✖︎ 間違った");
                    btnNext.setVisible(false);
                }
            }
        };

        ActionListener nextActionListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent actionEvent)
            {
                idx++;
                String next = nextQuestion();

                if (next == null || next.equals("FINISHED")) {
                    JOptionPane.showMessageDialog(frame, "全部答えでしました。");
                }else {
                    txtAnswer.setText("");
                    lbQuestion.setText(next);
                    lbMessage.setText("");
                    btnNext.setVisible(false);
                    btnCheck.setVisible(true);
                }

            }
        };

        btnCheck.addActionListener(saveActionListener);
        btnNext.addActionListener(nextActionListener);

        Container con = frame.getContentPane();
        con.setLayout(new GridLayout(4, 1));
        con.add(pnQuestion);
        con.add(pnText);
        con.add(pnMessage);
        con.add(pnButton);

        // set active
        frame.setVisible(true);

    }


    private void init_questions()
    {
        q = new Question();
        this.listQuestions = q.getQuestions();
        idx = 0;
        // for (String ques : this.listQuestions) {
        //     System.out.println(ques);
        // }
    }

    private boolean checkQuestion(String answer)
    {
        String tmp = this.listQuestions[idx];

        if (tmp != null && tmp != "") {
            String[] question = tmp.split(",");
            System.out.println(question[1]);
            if (answer.equals(question[1]) ) {
                score++;
                q.saveQuestion(idx,question[0], "正しい");
                return true;
            }
        }

        return false;

    }

    private String nextQuestion()
    {
        if (idx > this.listQuestions.length) {
            return "FINISHED";
        }
        String tmp = this.listQuestions[idx];
        if (tmp != null && tmp != "") {
            String[] question = tmp.split(",");
            return question[0];
        }

        return "FINISHED";
    }
}

class Question
{

    String[] listQuestions = new String[100];
    String inputFile = "questions.txt";
    String outputFile = "result1.txt";


    public String[] getQuestions()
    {
        try {
            FileInputStream fis;
            InputStreamReader isr;
            BufferedReader br;
            String line;

            fis = new FileInputStream(inputFile);
            isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);
            int i = 0;
            while ((line = br.readLine()) != null) {
                this.listQuestions[i] = line;
                i++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.listQuestions;
    }

    public void saveQuestion(int idx, String question, String flag)
    {
        Date today = new Date();

        FileOutputStream fos;
        OutputStreamWriter osw;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        outputFile = today.toString()+".txt";

        String out = "問題: "+(idx+1)+"　答え: "+question+" | "+flag;
        System.out.println(out);
        try
        {
            fos = new FileOutputStream(outputFile, true);
            osw = new OutputStreamWriter(fos, "UTF-8");

            bw = new BufferedWriter(osw);
            pw = new PrintWriter(bw);
            pw.println(out);
        }
        catch(IOException e){

        }finally{
            pw.close();
        }
    }

}

