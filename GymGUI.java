    import java.util.*;
    import javax.swing.*;
    import java.awt.*;
    import javax.swing.JPanel;
    import javax.swing.JComboBox;
    import javax.swing.JRadioButton;
    import java.awt.Color;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.*;
    import javax.swing.filechooser.FileFilter;
    
    @SuppressWarnings("unchecked")
    public class GymGUI extends JFrame implements ActionListener {
        ArrayList<GymMember> memberList = new ArrayList<>();
        private JFrame mainFrame;
        private JPanel mainPanel;
        private JLabel idLabel, nameLabel, emailLabel, dobLabel, referralLabel, planLabel, removalLabel, 
                      phoneLabel, locationLabel, startDateLabel, paidLabel, trainerLabel, genderLabel, 
                      titleLabel, discountLabel, premiumPriceLabel, regularPriceLabel;
        private JButton addRegularBtn, addPremiumBtn, activateBtn, deactivateBtn, 
                       attendanceBtn, revertBtn, displayBtn, clearBtn, saveToFileBtn, readFromFileBtn;
        private JComboBox yearCombo, monthCombo, dayCombo, referralCombo, planCombo, 
                         startYearCombo, startMonthCombo, startDayCombo;
        private JRadioButton maleRadio, femaleRadio;
        private JTextField idField, nameField, emailField, referralField, removalField, 
                          phoneField, locationField, paidField, trainerField, discountField;
        private ButtonGroup genderGroup;
        private JButton upgradePlanBtn,payDueAmountBtn;
    
        public void initializeGUI() {
            // Main window
            mainFrame = new JFrame();
            mainFrame.setTitle("Platinum Fitness");
            mainFrame.setResizable(false);
            mainFrame.setBounds(300, 60, 900, 750);
            mainFrame.setLayout(null);
            
            // Setting up the panel
            mainPanel = new JPanel();
            mainPanel.setBounds(0, 0, 900, 750);
            mainPanel.setBackground(Color.LIGHT_GRAY);
            mainPanel.setVisible(true);
            mainFrame.add(mainPanel);
            mainPanel.setLayout(null);
            
            // Title at the top
            titleLabel = new JLabel("Platinum Fitness");
            titleLabel.setBounds(350, 10, 300, 40);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            
            // Left side labels and fields
            idLabel = new JLabel("ID*: ");
            idLabel.setBounds(50, 70, 100, 30);
            idField = new JTextField(30);
            idField.setBounds(160, 70, 200, 30);
            
            nameLabel = new JLabel("Name*: ");
            nameLabel.setBounds(50, 110, 100, 30);
            nameField = new JTextField(30);
            nameField.setBounds(160, 110, 200, 30);
            
            emailLabel = new JLabel("Email*: ");
            emailLabel.setBounds(50, 150, 100, 30);
            emailField = new JTextField(30);
            emailField.setBounds(160, 150, 200, 30);
            
            dobLabel = new JLabel("DOB:* ");
            dobLabel.setBounds(50, 190, 100, 30);
            
            referralLabel = new JLabel("Referral Source: ");
            referralLabel.setBounds(50, 230, 100, 30);
            referralField = new JTextField(30);
            referralField.setBounds(160, 230, 200, 30);
            
            planLabel = new JLabel("Plan: ");
            planLabel.setBounds(50, 270, 100, 30);
            
            removalLabel = new JLabel("Removal Reason: ");
            removalLabel.setBounds(50, 310, 110, 30);
            removalField = new JTextField(30);
            removalField.setBounds(160, 310, 200, 30);
            
            regularPriceLabel = new JLabel("Regular plan price:");
            regularPriceLabel.setBounds(50, 350, 120, 30);
            JTextField regularPlanField = new JTextField("6500.00");
            regularPlanField.setEditable(false);
            regularPlanField.setBounds(160, 350, 200, 30);
            
            // Right side labels and fields
            phoneLabel = new JLabel("Phone*: ");
            phoneLabel.setBounds(450, 70, 100, 30);
            phoneField = new JTextField(30);
            phoneField.setBounds(560, 70, 200, 30);
            
            locationLabel = new JLabel("Location*: ");
            locationLabel.setBounds(450, 110, 100, 30);
            locationField = new JTextField(30);
            locationField.setBounds(560, 110, 200, 30);
            
            startDateLabel = new JLabel("Start Date*: ");
            startDateLabel.setBounds(450, 150, 100, 30);
            
            paidLabel = new JLabel("Paid Amount: ");
            paidLabel.setBounds(450, 190, 100, 30);
            paidField = new JTextField(30);
            paidField.setBounds(560, 190, 200, 30);
            
            trainerLabel = new JLabel("Trainers Name:");
            trainerLabel.setBounds(450, 230, 100, 30);
            trainerField = new JTextField(30);
            trainerField.setBounds(560, 230, 200, 30);
            
            genderLabel = new JLabel("Gender*:");
            genderLabel.setBounds(450, 270, 100, 30);
            
            discountLabel = new JLabel("Discount Amount:");
            discountLabel.setBounds(450, 310, 100, 30);
            discountField = new JTextField(30);
            discountField.setBounds(560, 310, 200, 30);
            
            premiumPriceLabel = new JLabel("Premium plan price:");
            premiumPriceLabel.setBounds(450, 350, 140, 30);
            JTextField premiumPlanField = new JTextField("50000.00");
            premiumPlanField.setEditable(false);
            premiumPlanField.setBounds(560, 350, 200, 30);
            
            mainPanel.add(regularPlanField);
            mainPanel.add(premiumPlanField);
    
            // For year of DOB
            int startYear = 2025;
            int totalYears = 100;
            String[] years = new String[totalYears];
            for (int i = 0; i < totalYears; i++) {
                years[i] = String.valueOf(startYear - i);
            }
            yearCombo = new JComboBox(years);
            yearCombo.setBounds(160, 190, 60, 30);
             
            // For Month of DOB
            String[] months = {"January", "February", "March", "April", "May", "June", 
                              "July", "August", "September", "October", "November", "December"};
            monthCombo = new JComboBox(months);
            monthCombo.setBounds(225, 190, 80, 30);
             
            // For Days of DOB
            int totalDays = 31;
            String[] days = new String[totalDays];
            for (int j = 0; j < totalDays; j++) {
                days[j] = String.valueOf(j + 1);
            }
            dayCombo = new JComboBox(days);
            dayCombo.setBounds(310, 190, 50, 30);
             
            // Combo box for plan
            String[] plans = {"Basic", "Standard", "Delux"};
            planCombo = new JComboBox(plans);
            planCombo.setBounds(160, 270, 200, 30);
           
            // Combo boxes for Membership Start date
            startYearCombo = new JComboBox(years);
            startYearCombo.setBounds(560, 150, 60, 30);
            startMonthCombo = new JComboBox(months);
            startMonthCombo.setBounds(625, 150, 80, 30);
            startDayCombo = new JComboBox(days);
            startDayCombo.setBounds(710, 150, 50, 30);
             
            // Radio buttons for gender
            maleRadio = new JRadioButton("Male");
            maleRadio.setBounds(560, 270, 90, 30);
            femaleRadio = new JRadioButton("Female");
            femaleRadio.setBounds(660, 270, 100, 30);
             
            genderGroup = new ButtonGroup();
            genderGroup.add(maleRadio);
            genderGroup.add(femaleRadio);
             
            // Calculate button dimensions for 3 columns
            int buttonWidth = 260;  // Increased width for better appearance
            int buttonHeight = 45;
            int hGap = 30;  // Gap between buttons horizontally
            int startX = 30;
            
            // Creating buttons - First row (430)
            addRegularBtn = new JButton("Add a Regular Member");
            addRegularBtn.setBounds(startX, 430, buttonWidth, buttonHeight);
            addRegularBtn.addActionListener(this);
           
            addPremiumBtn = new JButton("Add a Premium Member");
            addPremiumBtn.setBounds(startX + buttonWidth + hGap, 430, buttonWidth, buttonHeight);
            addPremiumBtn.addActionListener(this);
           
            activateBtn = new JButton("Activate Membership");
            activateBtn.setBounds(startX + (buttonWidth + hGap) * 2, 430, buttonWidth, buttonHeight);
            activateBtn.addActionListener(this);
             
            // Second row (500)
            deactivateBtn = new JButton("Deactivate Membership");
            deactivateBtn.setBounds(startX, 500, buttonWidth, buttonHeight);
            deactivateBtn.addActionListener(this);
               
            attendanceBtn = new JButton("Mark Attendance");
            attendanceBtn.setBounds(startX + buttonWidth + hGap, 500, buttonWidth, buttonHeight);
            attendanceBtn.addActionListener(this);
             
            revertBtn = new JButton("Revert Member");
            revertBtn.setBounds(startX + (buttonWidth + hGap) * 2, 500, buttonWidth, buttonHeight);
            revertBtn.addActionListener(this);
             
            // Third row (570)
            upgradePlanBtn = new JButton("Upgrade Plan");
            upgradePlanBtn.setBounds(startX, 570, buttonWidth, buttonHeight);
            upgradePlanBtn.addActionListener(this);
            
            payDueAmountBtn = new JButton("payDueAmount");
            payDueAmountBtn.setBounds(startX + buttonWidth + hGap, 570, buttonWidth, buttonHeight);
            payDueAmountBtn.addActionListener(this);
            
            displayBtn = new JButton("Display");
            displayBtn.setBounds(startX + (buttonWidth + hGap) * 2, 570, buttonWidth, buttonHeight);
            displayBtn.addActionListener(this);
            
            // Fourth row (640) - File Operations
            saveToFileBtn = new JButton("Save to File");
            saveToFileBtn.setBounds(startX, 640, buttonWidth, buttonHeight);
            saveToFileBtn.addActionListener(this);
            
            readFromFileBtn = new JButton("Read from File");
            readFromFileBtn.setBounds(startX + buttonWidth + hGap, 640, buttonWidth, buttonHeight);
            readFromFileBtn.addActionListener(this);
            
            clearBtn = new JButton("Clear");
            clearBtn.setBounds(startX + (buttonWidth + hGap) * 2, 640, buttonWidth, buttonHeight);
            clearBtn.addActionListener(this);
            
            mainPanel.add(upgradePlanBtn);
            mainPanel.add(payDueAmountBtn);
            mainPanel.add(saveToFileBtn);
            mainPanel.add(readFromFileBtn);
         
            // Adding labels to the panel
            mainPanel.add(idLabel);
            mainPanel.add(nameLabel);
            mainPanel.add(emailLabel);
            mainPanel.add(dobLabel);
            mainPanel.add(referralLabel);
            mainPanel.add(planLabel);
            mainPanel.add(removalLabel);
            mainPanel.add(phoneLabel);
            mainPanel.add(locationLabel);
            mainPanel.add(startDateLabel);
            mainPanel.add(paidLabel);
            mainPanel.add(trainerLabel);
            mainPanel.add(genderLabel);
            mainPanel.add(titleLabel);
            mainPanel.add(discountLabel);
            mainPanel.add(premiumPriceLabel);
            mainPanel.add(regularPriceLabel);
            
            // Adding the text fields to the panel
            mainPanel.add(idField);
            mainPanel.add(nameField);
            mainPanel.add(emailField);
            mainPanel.add(referralField);
            mainPanel.add(removalField);
            mainPanel.add(phoneField);
            mainPanel.add(locationField);
            mainPanel.add(paidField);
            mainPanel.add(trainerField);
            mainPanel.add(discountField);
            
            // Adding the combo boxes
            mainPanel.add(yearCombo);
            mainPanel.add(monthCombo);
            mainPanel.add(dayCombo);
            mainPanel.add(planCombo);
            mainPanel.add(startYearCombo);
            mainPanel.add(startMonthCombo);
            mainPanel.add(startDayCombo);
            
            // Adding the radio buttons
            mainPanel.add(maleRadio);
            mainPanel.add(femaleRadio);
            
            // Adding buttons to the panel
            mainPanel.add(addRegularBtn);
            mainPanel.add(addPremiumBtn);
            mainPanel.add(activateBtn);
            mainPanel.add(deactivateBtn);
            mainPanel.add(attendanceBtn);
            mainPanel.add(revertBtn);
            mainPanel.add(displayBtn);
            mainPanel.add(clearBtn);
            
            mainFrame.setVisible(true);
        }
        
        private boolean validateInputs() {
            if (idField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty() ||
                locationField.getText().trim().isEmpty() || phoneField.getText().trim().isEmpty() ||
                emailField.getText().trim().isEmpty() || !(maleRadio.isSelected() || femaleRadio.isSelected())) {
                JOptionPane.showMessageDialog(this, "All fields marked with * are required!");
                return false;
            }
            // Email validation
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
            if (!emailField.getText().matches(emailRegex)) {
                JOptionPane.showMessageDialog(this, "Invalid email format!");
                return false;
            }
            
            // Phone validation
            String phoneRegex = "^[0-9]{10}$";
            if (!phoneField.getText().matches(phoneRegex)) {
                JOptionPane.showMessageDialog(this, "Phone number must be 10 digits!");
                return false;
            }
            
            return true;
    }
    
    public GymMember findMemberById(int id) {
        for (GymMember member : memberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;  // Return null if the member is not found
    }
    
    private boolean isDuplicateID(String idText) {
        try {
            int id = Integer.parseInt(idText);
            for (GymMember member : memberList) {
                if (member.getId() == id) {
                    return true;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid ID format. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addRegularBtn) {
                try {
                    if (!validateInputs()) {
                        return;
                    }
                    
                    if (isDuplicateID(idField.getText())) {
                        JOptionPane.showMessageDialog(this, "This ID is already in use. Please choose a different ID.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText().trim();
                    String location = locationField.getText().trim();
                    String phone = phoneField.getText().trim();
                    String email = emailField.getText().trim();
                    String gender = maleRadio.isSelected() ? "Male" : "Female";
                    String dob = dayCombo.getSelectedItem() + "-" + monthCombo.getSelectedItem() + "-" + yearCombo.getSelectedItem();
                    String startDate = startDayCombo.getSelectedItem() + "-" + startMonthCombo.getSelectedItem() + "-" + startYearCombo.getSelectedItem();
    
                    RegularMember regular = new RegularMember(id, name, location, phone, email, gender, dob, startDate);
                    memberList.add(regular);
                    JOptionPane.showMessageDialog(this, "Regular member added successfully!");
                    clearBtn.doClick(); // Clear the form after successful addition
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error adding member: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            else if (e.getSource() == addPremiumBtn) {
                try {
                    if (!validateInputs()) {
                        return;
                    }
                    
                    String trainer = trainerField.getText().trim();
                    if (trainer.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Trainer name is required for Premium members.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (isDuplicateID(idField.getText())) {
                        JOptionPane.showMessageDialog(this, "This ID is already in use. Please choose a different ID.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    int id = Integer.parseInt(idField.getText());
                    String name = nameField.getText().trim();
                    String location = locationField.getText().trim();
                    String phone = phoneField.getText().trim();
                    String email = emailField.getText().trim();
                    String gender = maleRadio.isSelected() ? "Male" : "Female";
                    String dob = dayCombo.getSelectedItem() + "-" + monthCombo.getSelectedItem() + "-" + yearCombo.getSelectedItem();
                    String startDate = startDayCombo.getSelectedItem() + "-" + startMonthCombo.getSelectedItem() + "-" + startYearCombo.getSelectedItem();
    
                    PremiumMember premium = new PremiumMember(id, name, location, phone, email, gender, dob, startDate, trainer);
                    memberList.add(premium);
                    JOptionPane.showMessageDialog(this, "Premium member added successfully!");
                    clearBtn.doClick(); // Clear the form after successful addition
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error adding member: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            else if (e.getSource() == displayBtn) {
                if (memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No members to display.");
                    return;
                }
    
                StringBuilder content = new StringBuilder();
                content.append("Total Members: ").append(memberList.size()).append("\n\n");
    
                for (GymMember member : memberList) {
                    content.append("ID: ").append(member.getId())
                          .append("\nName: ").append(member.getName())
                          .append("\nLocation: ").append(member.getLocation())
                          .append("\nPhone: ").append(member.getPhone())
                          .append("\nEmail: ").append(member.getEmail())
                          .append("\nGender: ").append(member.getGender())
                          .append("\nDOB: ").append(member.getDOB())
                          .append("\nMembership Start Date: ").append(member.getMembershipStartDate())
                          .append("\nType: ").append(member instanceof PremiumMember ? "Premium" : "Regular")
                          .append("\n").append("-".repeat(50)).append("\n");
                }
    
                JTextArea textArea = new JTextArea(content.toString());
                textArea.setEditable(false);
                textArea.setRows(20);
                textArea.setColumns(50);
    
                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(this, scrollPane, "Member Details", JOptionPane.INFORMATION_MESSAGE);
            } 
            else if (e.getSource() == clearBtn) {
                idField.setText(""); 
                nameField.setText(""); 
                locationField.setText("");
                phoneField.setText(""); 
                emailField.setText(""); 
                referralField.setText("");
                paidField.setText(""); 
                removalField.setText(""); 
                trainerField.setText("");
                genderGroup.clearSelection(); 
                planCombo.setSelectedIndex(0);
            }
            else if (e.getSource() == activateBtn) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    GymMember member = findMemberById(id);
                    
                    if (member != null) {
                        member.activateMembership();
                        JOptionPane.showMessageDialog(this, "Membership activated for member ID: " + id);
                    } else {
                        JOptionPane.showMessageDialog(this, "Member not found!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid member ID.");
                }
            }
            else if (e.getSource() == deactivateBtn) {
                try {
                    int id = Integer.parseInt(idField.getText());
                    GymMember member = findMemberById(id);
                    if (member != null) {
                        if (!member.getActiveStatus()) {
                            JOptionPane.showMessageDialog(this, "Membership is already deactivated.");
                        } else {
                            member.deactiveMembership();
                            JOptionPane.showMessageDialog(this, "Membership deactivated for member ID: " + id);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Member not found!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid member ID.");
                }
            }
            else if (e.getSource() == attendanceBtn) {
                try {
                    String enteredId = idField.getText().trim();
                    
                    if (enteredId.isEmpty()) {
                        JOptionPane.showMessageDialog(mainFrame, "Please enter Member ID to mark attendance.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    int id = Integer.parseInt(enteredId);
                    GymMember member = findMemberById(id);
                    
                    if (member != null) {
                        if (member.getActiveStatus()) {
                            member.markAttendance();
                            JOptionPane.showMessageDialog(mainFrame, "Attendance marked for member: " + member.getName(), "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(mainFrame, "Membership is not active. Cannot mark attendance.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(mainFrame, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainFrame, "Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainFrame, "Error marking attendance: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (e.getSource() == revertBtn) {
                try {
                    String idText = idField.getText().trim();
                    String reason = removalField.getText().trim();
                    
                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter a member ID.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (reason.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please enter a removal reason!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    int id = Integer.parseInt(idText);
                    GymMember member = findMemberById(id);
                    
                    if (member != null) {
                        if (member instanceof RegularMember) {
                            ((RegularMember) member).revertRegularMember(reason);
                        } else if (member instanceof PremiumMember) {
                            ((PremiumMember) member).revertPremiumMember(reason);
                        }
                        PrintWriter writer = new PrintWriter(new FileWriter("MemberDetails.txt"));
                
                // Write headers
                writer.println("Member Details\n");
                writer.println("-".repeat(50));
                
                // Write member details
                for (GymMember member1 : memberList) {
                    writer.println("ID: " + member1.getId());
                    writer.println("Name: " + member1.getName());
                    writer.println("Location: " + member1.getLocation());
                    writer.println("Phone: " + member1.getPhone());
                    writer.println("Email: " + member1.getEmail());
                    writer.println("Gender: " + member1.getGender());
                    writer.println("DOB: " + member1.getDOB());
                    writer.println("Membership Start Date: " + member1.getMembershipStartDate());
                    writer.println("Type: " + (member1 instanceof PremiumMember ? "Premium" : "Regular"));
                    writer.println("-".repeat(50));
                    writer.println();
                }
                
                writer.close();
                JOptionPane.showMessageDialog(this, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        clearBtn.doClick(); // Clear form after successful revert
                    } else {
                        JOptionPane.showMessageDialog(this, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error reverting member: ", "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        else if (e.getSource() == upgradePlanBtn) {
            try {
                String idText = idField.getText().trim();
                
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter a member ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int id = Integer.parseInt(idText);
                GymMember member = findMemberById(id);
                
                if (member == null) {
                    JOptionPane.showMessageDialog(this, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (!(member instanceof RegularMember)) {
                    JOptionPane.showMessageDialog(this, "Only Regular members can be upgraded!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                RegularMember regularMember = (RegularMember) member;
                String selectedPlan = (String) planCombo.getSelectedItem();
                
                if (selectedPlan == null || selectedPlan.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please select a plan to upgrade to.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                String result = regularMember.upgradePlan(selectedPlan);
                JOptionPane.showMessageDialog(this, result, "Success", JOptionPane.INFORMATION_MESSAGE);
                clearBtn.doClick(); // Clear form after successful upgrade
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error upgrading plan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == payDueAmountBtn) {
            try {
                String idText = idField.getText().trim();
                String amountText = paidField.getText().trim();
                
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter a member ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (amountText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter a payment amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int id = Integer.parseInt(idText);
                GymMember member = findMemberById(id);
                
                if (member == null) {
                    JOptionPane.showMessageDialog(this, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if (!(member instanceof PremiumMember)) {
                    JOptionPane.showMessageDialog(this, "Only Premium members can make payments!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                double amount;
                try {
                    amount = Double.parseDouble(amountText);
                    if (amount <= 0) {
                        throw new IllegalArgumentException("Payment amount must be positive.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                PremiumMember premiumMember = (PremiumMember) member;//downcasting
                String paymentResult = premiumMember.payDueAmount(amount);
                String discountResult = premiumMember.calculateDiscount();
                
                JOptionPane.showMessageDialog(this, 
                    paymentResult + "\n" + discountResult,
                    "Payment Processed", 
                    JOptionPane.INFORMATION_MESSAGE);
                
                clearBtn.doClick(); // Clear form after successful payment
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error processing payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == readFromFileBtn) {
            try {
                File file = new File("MemberDetails.txt");
                
                if (!file.exists()) {
                    JOptionPane.showMessageDialog(this, "File 'MemberDetails.txt' not found.");
                    return;
                }
                
                StringBuilder content = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
                // Show file contents in a message dialog with scroll bars if needed
                JTextArea textArea = new JTextArea(content.toString());
                textArea.setEditable(false);
                textArea.setRows(20);
                textArea.setColumns(50);
                
                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(this, scrollPane, "Member Details", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading file.");
            }
        }
        else if (e.getSource() == saveToFileBtn) {
            try {
                if (memberList.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No members to save.");
                    return;
                }
                
                PrintWriter writer = new PrintWriter(new FileWriter("MemberDetails.txt"));
                
                // Write headers
                writer.println("Member Details\n");
                writer.println("-".repeat(50));
                
                // Write member details
                for (GymMember member : memberList) {
                    writer.println("ID: " + member.getId());
                    writer.println("Name: " + member.getName());
                    writer.println("Location: " + member.getLocation());
                    writer.println("Phone: " + member.getPhone());
                    writer.println("Email: " + member.getEmail());
                    writer.println("Gender: " + member.getGender());
                    writer.println("DOB: " + member.getDOB());
                    writer.println("Membership Start Date: " + member.getMembershipStartDate());
                    writer.println("Type: " + (member instanceof PremiumMember ? "Premium" : "Regular"));
                    writer.println("-".repeat(50));
                    writer.println();
                }
                
                writer.close();
                JOptionPane.showMessageDialog(this, "Data saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file.");
            }
        }
    }
        public static void main(String[] args) {
            GymGUI gymGUI = new GymGUI();
            gymGUI.initializeGUI();
        }
    }
