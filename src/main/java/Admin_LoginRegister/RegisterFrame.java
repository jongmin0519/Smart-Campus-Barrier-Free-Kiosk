package Admin_LoginRegister;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import models.User1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterFrame extends JFrame {
    private JTextField txtUsername;
    private JButton btnCheckDuplicate;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JTextField txtStudentId;
    private JTextField txtname;
    private JTextField txtPhoneNumber;
    private JButton btnRegister;
    private JButton btnCancel;
    private JLabel lblConfirmPasswordStatus;
    private JComboBox<String> comboMajor;

    public RegisterFrame() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("회원가입");
        setSize(700, 600);
        setLocationRelativeTo(null);
        btnRegister.setEnabled(false);
    }
    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 3, 5, 5));
        panel.setBackground(new Color(96, 140, 255));
        JLabel lblUsername = new JLabel("아이디:(ID 중복확인 필수!)");
        JLabel lblPassword = new JLabel("비밀번호:");
        JLabel lblConfirmPassword = new JLabel("비밀번호 확인:");
        JLabel lblMajor = new JLabel("학과:");
        JLabel lblStudentId = new JLabel("학번:");
        JLabel lblname = new JLabel("이름:");
        JLabel lblPhoneNumber = new JLabel("전화번호:");
        JComboBox<String> comboMostPreciousThing = new JComboBox<>();
        comboMostPreciousThing.addItem("당신의 가장 소중한것은?");
        comboMostPreciousThing.addItem("당신이 나온 초등학교는?");
        comboMostPreciousThing.addItem("당신이 나온 중학교는?");

        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        txtConfirmPassword = new JPasswordField(20);
        txtStudentId = new JTextField(20);
        txtname = new JTextField(20);
        txtPhoneNumber = new JTextField(20);
        JTextField txtMostPreciousThing = new JTextField(20);

        btnCheckDuplicate = new JButton("중복확인");
        btnCheckDuplicate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                boolean isDuplicate = checkDuplicate(username);

                if (isDuplicate) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "중복된 아이디입니다.", "중복확인", JOptionPane.WARNING_MESSAGE);
                    btnRegister.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "사용 가능한 아이디입니다.", "중복확인", JOptionPane.INFORMATION_MESSAGE);
                    btnRegister.setEnabled(true);
                }
            }
        });

        JPanel passwordPanel = new JPanel(new BorderLayout());
        passwordPanel.add(txtPassword, BorderLayout.CENTER);
        JButton btnTogglePassword = new JButton("👁️");
        passwordPanel.add(btnTogglePassword, BorderLayout.EAST);
        btnTogglePassword.addActionListener(new ActionListener() {
            private boolean passwordVisible = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                passwordVisible = !passwordVisible;
                txtPassword.setEchoChar(passwordVisible ? '\0' : (char) 0x2022);
            }
        });

        JPanel confirmPasswordPanel = new JPanel(new BorderLayout());
        confirmPasswordPanel.add(txtConfirmPassword, BorderLayout.CENTER);
        JButton btnToggleConfirmPassword = new JButton("👁️");
        confirmPasswordPanel.add(btnToggleConfirmPassword, BorderLayout.EAST);
        btnToggleConfirmPassword.addActionListener(new ActionListener() {
            private boolean confirmPasswordVisible = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                confirmPasswordVisible = !confirmPasswordVisible;
                txtConfirmPassword.setEchoChar(confirmPasswordVisible ? '\0' : (char) 0x2022);
            }
        });
        btnRegister = new JButton("확인");
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                String confirmPassword = new String(txtConfirmPassword.getPassword());
                String studentId = txtStudentId.getText();
                if (!isValidStudentId(studentId)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "학번을 다시 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (checkDuplicateStudentId(studentId)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "학번 중복입니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String name = txtname.getText();
                String phoneNumber = txtPhoneNumber.getText();
                if (!isValidPhoneNumber(phoneNumber)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "전화번호는 11자리의 숫자만 가능합니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (checkDuplicatePhoneNumber(phoneNumber)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "휴대폰 번호 중복입니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String major = (String) comboMajor.getSelectedItem();
                String mostPreciousThing = txtMostPreciousThing.getText();

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || studentId.isEmpty()
                        || name.isEmpty() || phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "모든 정보를 입력해주세요!", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "비밀번호가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                User1 user1 = new User1(username, password, major, studentId, name, phoneNumber, mostPreciousThing);
                boolean isSaved = saveUser1ToDatabase(user1);

                if (isSaved) {
                    dispose();
                    LoginFrame loginFrame = new LoginFrame();
                    loginFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "회원가입에 실패하였습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        


        btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        lblConfirmPasswordStatus = new JLabel();
        lblConfirmPasswordStatus.setForeground(Color.RED);

        comboMajor = new JComboBox<String>();
        comboMajor.addItem("기계공학과");
        comboMajor.addItem("기계설계공학과");
        comboMajor.addItem("로봇공학과");
        comboMajor.addItem("자동화공학과");
        comboMajor.addItem("전기공학과");
        comboMajor.addItem("정보전자공학과");
        comboMajor.addItem("반도체전자공학과");
        comboMajor.addItem("정보통신공학과");
        comboMajor.addItem("소방안전관리과");
        comboMajor.addItem("컴퓨터소프트웨어공학과");
        comboMajor.addItem("컴퓨터정보공학과");
        comboMajor.addItem("인공지능소프트웨어공학과");
        comboMajor.addItem("생명화학공학과");
        comboMajor.addItem("바이오융합공학과");
        comboMajor.addItem("건축과");
        comboMajor.addItem("실내건축디자인과");
        comboMajor.addItem("시각디자인과");
        comboMajor.addItem("경영학과");
        comboMajor.addItem("세무회계학과");
        comboMajor.addItem("유통마케팅학과");
        comboMajor.addItem("호텔관광학과");
        comboMajor.addItem("경영정보학과");
        comboMajor.addItem("빅데이터경영과");
        
        

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(btnCheckDuplicate); 
        panel.add(lblPassword);
        panel.add(passwordPanel);
        panel.add(lblConfirmPasswordStatus); 
        panel.add(lblConfirmPassword);
        panel.add(confirmPasswordPanel);
        panel.add(new JLabel()); 
        panel.add(lblMajor);
        panel.add(comboMajor);
        panel.add(new JLabel());
        panel.add(lblStudentId);
        panel.add(txtStudentId);
        panel.add(new JLabel());
        panel.add(lblname);
        panel.add(txtname);
        panel.add(new JLabel());
        panel.add(lblPhoneNumber);
        panel.add(txtPhoneNumber);
        panel.add(new JLabel());
        panel.add(comboMostPreciousThing);
        panel.add(txtMostPreciousThing);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(btnRegister);
        panel.add(btnCancel);

        add(panel);
        
        DocumentListener passwordCheckListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPasswordMatch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPasswordMatch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkPasswordMatch();
            }

            private void checkPasswordMatch() {
                String password = new String(txtPassword.getPassword());
                String confirmPassword = new String(txtConfirmPassword.getPassword());

                if (!password.equals(confirmPassword)) {
                    lblConfirmPasswordStatus.setText("비밀번호가 다릅니다.");
                } else {
                    lblConfirmPasswordStatus.setText("");
                }
            }
        };

        txtPassword.getDocument().addDocumentListener(passwordCheckListener);
        txtConfirmPassword.getDocument().addDocumentListener(passwordCheckListener);

    }

    private boolean checkDuplicate(String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_order_kiosk?serverTimezone=UTC&characterEncoding=utf-8", "root", "1234");
            String sql = "SELECT * FROM user1 WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean saveUser1ToDatabase(User1 user1) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_order_kiosk?serverTimezone=UTC&characterEncoding=utf-8", "root", "1234");
            String sql = "INSERT INTO user1 (username, password, major, studentId, name, phoneNumber,mostPreciousThing) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user1.getUsername());
            statement.setString(2, user1.getPassword());
            statement.setString(3, user1.getMajor());
            statement.setString(4, user1.getStudentId());
            statement.setString(5, user1.getname());
            statement.setString(6, user1.getPhoneNumber());
            statement.setString(7, user1.getMostPreciousThing());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        RegisterFrame registerFrame = new RegisterFrame();
        registerFrame.setVisible(true);
    }    
    
    private boolean isValidStudentId(String studentId) {
        if (studentId.length() != 8) {
            return false;
        }
        for (char c : studentId.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return false;
        }
        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    private boolean checkDuplicateStudentId(String studentId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_order_kiosk?serverTimezone=UTC&characterEncoding=utf-8", "root", "1234");
            String sql = "SELECT * FROM user1 WHERE studentId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean checkDuplicatePhoneNumber(String phoneNumber) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/self_order_kiosk?serverTimezone=UTC&characterEncoding=utf-8", "root", "1234");
            String sql = "SELECT * FROM user1 WHERE phoneNumber = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, phoneNumber);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}