import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

public class Screen extends JPanel implements ActionListener {
    private List<Contact> contactList;
    private List<Contact> contacts;
    private JTextPane allContactsPane, searchResultsPane;
    private JButton searchFirstButton, searchLastButton, searchUserButton, searchDomainButton, searchExtensionButton, searchByFirstName, searchByLastName, searchByEmail, addContact;
    private JButton lastButton = searchFirstButton;
    private JTextField searchInput, firstNameInput, lastNameInput, emailInput;
    private Comparator sort = Contact.Comparators.LASTNAME;
    public Screen() {
        this.setLayout(null);
        contactList = new ArrayList<Contact>();
        contactList.add(new Contact("John", "Duck", "jduck@gmail.com"));
        contactList.add(new Contact("Bob", "Ross", "bob.ross@gmail.com"));
        contactList.add(new Contact("Elizabeth", "Doe", "doe.beth@hotmail.net"));
        contactList.add(new Contact("John", "Miller", "johnthemiller@gmail.com"));
        contactList.add(new Contact("Elizabeth", "Smith", "elizabeth.adrian.smith@texas.edu"));
        int width = (int)getPreferredSize().getWidth();
        int height = (int)getPreferredSize().getHeight();
        int topheight = 170;
        allContactsPane = new JTextPane();
        allContactsPane.setBounds(10, topheight, width/2-15, height-topheight-10);
        this.add(allContactsPane);
        String contactStr = "";
        for (int i = 0; i < contactList.size(); i++) {
            contactStr += contactList.get(i) + "\n";
        }
        allContactsPane.setText(contactStr);

        searchResultsPane = new JTextPane();
        searchResultsPane.setBounds(width/2+5, topheight, width/2-15, height-topheight-10);
        this.add(searchResultsPane);
        searchResultsPane.setText(contactStr);
        
        int buttonwid = (width-10)/5;
        
        searchFirstButton = new JButton("Search First Name");
        searchFirstButton.setBounds(10, 50, buttonwid-10, 30);
        searchFirstButton.addActionListener(this);
        this.add(searchFirstButton);

        searchLastButton = new JButton("Search Last Name");
        searchLastButton.setBounds(buttonwid+10, 50, buttonwid-10, 30);
        searchLastButton.addActionListener(this);
        this.add(searchLastButton);

        searchUserButton = new JButton("Search User Name");
        searchUserButton.setBounds(buttonwid*2+10, 50, buttonwid-10, 30);
        searchUserButton.addActionListener(this);
        this.add(searchUserButton);

        searchDomainButton = new JButton("Search Domain Name");
        searchDomainButton.setBounds(buttonwid*3+10, 50, buttonwid-10, 30);
        searchDomainButton.addActionListener(this);
        this.add(searchDomainButton);

        searchExtensionButton = new JButton("Search Domain Extension");
        searchExtensionButton.setBounds(buttonwid*4+10, 50, buttonwid-10, 30);
        searchExtensionButton.addActionListener(this);
        this.add(searchExtensionButton);
        
        
        buttonwid = (width-10)/3;
        
        searchByFirstName = new JButton("Sort By First Name");
        searchByFirstName.setBounds(10, 90, buttonwid-10, 30);
        searchByFirstName.addActionListener(this);
        this.add(searchByFirstName);

        searchByLastName = new JButton("Sort By Last Name");
        searchByLastName.setBounds(buttonwid+10, 90, buttonwid-10, 30);
        searchByLastName.addActionListener(this);
        this.add(searchByLastName);

        searchByEmail = new JButton("Sort By Email");
        searchByEmail.setBounds(buttonwid*2+10, 90, buttonwid-10, 30);
        searchByEmail.addActionListener(this);
        this.add(searchByEmail);
        
        searchInput = new JTextField();
        searchInput.setBounds(10, 10, width-20, 30);
        this.add(searchInput);

        
        buttonwid = (width-10)/4;

        firstNameInput = new JTextField();
        firstNameInput.setBounds(10, 130, buttonwid-10, 30);
        this.add(firstNameInput);

        lastNameInput = new JTextField();
        lastNameInput.setBounds(10+buttonwid, 130, buttonwid-10, 30);
        this.add(lastNameInput);

        emailInput = new JTextField();
        emailInput.setBounds(10+buttonwid*2, 130, buttonwid-10, 30);
        this.add(emailInput);

        addContact = new JButton("Add Contact");
        addContact.setBounds(10+buttonwid*3, 130, buttonwid-10, 30);
        addContact.addActionListener(this);
        this.add(addContact);

        
        this.setFocusable(true);
    }

    public Dimension getPreferredSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    public void updateStr() {
        contacts = new LinkedList<Contact>();
        String search = searchInput.getText();
        if (lastButton == searchFirstButton) {
            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getFirstName().equals(search)) {
                    contacts.add(contactList.get(i));
                }
            }
        } else if (lastButton == searchLastButton) {
            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getLastName().equals(search)) {
                    contacts.add(contactList.get(i));
                }
            }          
        } else if (lastButton == searchUserButton) {
            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getUserName().equals(search)) {
                    contacts.add(contactList.get(i));
                }
            }
        } else if (lastButton == searchDomainButton) {
            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getDomainName().equals(search)) {
                    contacts.add(contactList.get(i));
                }
            }
        } else if (lastButton == searchExtensionButton) {
            for (int i = 0; i < contactList.size(); i++) {
                if (contactList.get(i).getDomainExtension().equals(search)) {
                    contacts.add(contactList.get(i));
                }
            }
        }
        Collections.sort(contacts, sort);
        String contactStr = "";
        for (int i = 0; i < contacts.size(); i++) {
            contactStr += contacts.get(i) + "\n";
        }
        searchResultsPane.setText(contactStr);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchFirstButton || e.getSource() == searchLastButton || e.getSource() == searchUserButton || e.getSource() == searchDomainButton || e.getSource() == searchExtensionButton) {
            lastButton = (JButton)e.getSource();
        } else if (e.getSource() == searchByFirstName) {
            sort = Contact.Comparators.FIRSTNAME;
        } else if (e.getSource() == searchByLastName) {
            sort = Contact.Comparators.LASTNAME;
        } else if (e.getSource() == searchByEmail) {
            sort = Contact.Comparators.EMAIL;
        } else if (e.getSource() == addContact) {
            if (contactList.size()>=10) return;
            contactList.add(new Contact(firstNameInput.getText(), lastNameInput.getText(), emailInput.getText()));
            String contactStr = "";
            for (int i = 0; i < contactList.size(); i++) {
                contactStr += contactList.get(i) + "\n";
            }
            allContactsPane.setText(contactStr);
        }
        updateStr();
    }
}
