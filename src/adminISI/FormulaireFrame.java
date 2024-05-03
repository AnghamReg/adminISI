package adminISI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class FormulaireFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField matriculeTF;
	private JTextField NomTF;
	private JTextField contactTF;
	private JTextField matiereTF;
	private JTextField matriculeEnseignTF;
	private JTable tableEnseign;
	private JTable tableCours;
	private JScrollPane scrollPanelEnseign;
	private JScrollPane scrollPanelCours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormulaireFrame frame = new FormulaireFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	 public static boolean estNumeroTel(String chaine) {
	        // Vérifier si la chaîne est numérique et a une longueur de 8
	        return chaine.matches("\\d{8}");
	    }
	
	
	public FormulaireFrame() {
		setTitle("Formulaires ISI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 520);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel enseignantLabel = new JLabel("Formulaire d'enregistrement des enseignants");
		enseignantLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		enseignantLabel.setBounds(10, 45, 363, 22);
		contentPane.add(enseignantLabel);
		
		JLabel seanceLabel = new JLabel("Formulaire d'enregistrement des séances de cours\r\n");
		seanceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		seanceLabel.setBounds(10, 235, 418, 22);
		contentPane.add(seanceLabel);
		
		JLabel matriculeLabel = new JLabel("Matricule");
		matriculeLabel.setBounds(10, 80, 102, 13);
		contentPane.add(matriculeLabel);
		
		matriculeTF = new JTextField();
		matriculeTF.setBounds(122, 77, 77, 22);
		contentPane.add(matriculeTF);
		matriculeTF.setColumns(10);
		
		JLabel nomLabel = new JLabel("Nom");
		nomLabel.setBounds(10, 109, 102, 13);
		contentPane.add(nomLabel);
		
		JLabel contactLabel = new JLabel("Contact");
		contactLabel.setBounds(10, 135, 102, 13);
		contentPane.add(contactLabel);
		
		JButton chercherBtn = new JButton("CHERCHER");
		chercherBtn.setToolTipText("Chercher enseignant par nom");
		chercherBtn.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		chercherBtn.setBackground(new Color(209, 255, 189));
		chercherBtn.setBounds(205, 77, 120, 21);
		chercherBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NomTF.getText().length()==0) {
					String errorMsgFindEnseign="Veuillez spécifier un nom d'enseignant pour lancer la recherche.";
					JOptionPane.showMessageDialog(null,errorMsgFindEnseign,null,JOptionPane.ERROR_MESSAGE);
				}else {
					//TODO : rechercher un enseignant par nom
				}
			}
		});
		contentPane.add(chercherBtn);
		
		JButton enregistrerEnseignantBtn = new JButton("ENREGISTRER");
		enregistrerEnseignantBtn.setToolTipText("Ajouter enseignant");
		enregistrerEnseignantBtn.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		enregistrerEnseignantBtn.setBackground(new Color(209, 255, 189));
		enregistrerEnseignantBtn.setBounds(10, 161, 125, 21);
		enregistrerEnseignantBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matriculeTF.getText().length()==0 || NomTF.getText().length()==0 || contactTF.getText().length()==0) {
					String errorMsgAddEnseign="Une information essentielle est manquante pour procéder à l'ajout de l'enseignant. Veuillez fournir toutes les données nécessaires.";
						JOptionPane.showMessageDialog(null,errorMsgAddEnseign,null,JOptionPane.ERROR_MESSAGE);

				}else if (!estNumeroTel(contactTF.getText())) {
					String errorMsgAddEnseign="Format de numéro de téléphone invalide.";
					JOptionPane.showMessageDialog(null,errorMsgAddEnseign,null,JOptionPane.ERROR_MESSAGE);
				}else {
					//TODO : Ajouter un enseignant
				}
			}
		});
		contentPane.add(enregistrerEnseignantBtn);
		
		JButton modifierBtn = new JButton("MODIFIER");
		modifierBtn.setToolTipText("Modifier enseignant");
		modifierBtn.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		modifierBtn.setBackground(new Color(209, 255, 189));
		modifierBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matriculeTF.getText().length()==0) {
					String errorMsgUpdateEnseign="La matricule de l'enseignant est requise pour effectuer des modifications. Veuillez la saisir pour continuer.";
					JOptionPane.showMessageDialog(null,errorMsgUpdateEnseign,null,JOptionPane.ERROR_MESSAGE);

				}else if (NomTF.getText().length()==0 || contactTF.getText().length()==0) {
					String errorMsgUpdateEnseign="Une information essentielle est manquante pour procéder à la modification de l'enseignant "+matriculeTF.getText();
					JOptionPane.showMessageDialog(null,errorMsgUpdateEnseign,null,JOptionPane.ERROR_MESSAGE);

				}else if (!estNumeroTel(contactTF.getText())) {
					String errorMsgUpdateEnseign="Format de numéro de téléphone invalide.";
					JOptionPane.showMessageDialog(null,errorMsgUpdateEnseign,null,JOptionPane.ERROR_MESSAGE);
				}else {
					//TODO : Modifier un enseignant 
				}
			}
		});
		modifierBtn.setBounds(145, 161, 132, 21);
		contentPane.add(modifierBtn);
		
		JButton supprimerBtn = new JButton("SUPPRIMER");
		supprimerBtn.setToolTipText("Supprimer enseignant par matricule");
		supprimerBtn.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		supprimerBtn.setBackground(new Color(209, 255, 189));
		supprimerBtn.setBounds(80, 193, 120, 21);
		supprimerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matriculeTF.getText().length()==0) {
					String errorMsgDeleteEnseign="Veuillez spécifier une matricule pour supprimer un enseignant.";
					JOptionPane.showMessageDialog(null,errorMsgDeleteEnseign,null,JOptionPane.ERROR_MESSAGE);

				}else {
					//TODO : supprimer un enseignant
				}
			}
		});
		contentPane.add(supprimerBtn);
		
		NomTF = new JTextField();
		NomTF.setColumns(10);
		NomTF.setBounds(122, 106, 155, 22);
		contentPane.add(NomTF);
		
		contactTF = new JTextField();
		contactTF.setColumns(10);
		contactTF.setBounds(122, 131, 155, 22);
		contentPane.add(contactTF);
		
		JComboBox classeBox = new JComboBox();
		classeBox.addItem(" ");
		classeBox.setBounds(85, 267, 125, 21);
		contentPane.add(classeBox);
		
		JLabel classeLabel = new JLabel("Classe");
		classeLabel.setBounds(10, 267, 45, 13);
		contentPane.add(classeLabel);
		
		JLabel matiereBtn = new JLabel("Matiere");
		matiereBtn.setBounds(10, 297, 45, 13);
		contentPane.add(matiereBtn);
		
		JLabel jourBtn = new JLabel("Jour");
		jourBtn.setBounds(10, 329, 45, 13);
		contentPane.add(jourBtn);
		
		JLabel matriculeEnseignantLabel = new JLabel("Matricule enseignant ");
		matriculeEnseignantLabel.setBounds(10, 388, 125, 13);
		contentPane.add(matriculeEnseignantLabel);
		
		JLabel heureBtn = new JLabel("Heure");
		heureBtn.setBounds(10, 358, 45, 13);
		contentPane.add(heureBtn);
		
		JComboBox JourBox = new JComboBox();
		JourBox.addItem(" ");
		JourBox.setBounds(85, 325, 125, 21);
		contentPane.add(JourBox);
		
		JComboBox heureBox = new JComboBox();
		heureBox.addItem(" ");
		heureBox.setBounds(85, 357, 125, 21);
		contentPane.add(heureBox);
		
		matiereTF = new JTextField();
		matiereTF.setBounds(85, 298, 125, 22);
		contentPane.add(matiereTF);
		matiereTF.setColumns(10);
		
		matriculeEnseignTF = new JTextField();
		matriculeEnseignTF.setColumns(10);
		matriculeEnseignTF.setBounds(133, 384, 77, 22);
		contentPane.add(matriculeEnseignTF);
		
		//table enseignant
		DefaultTableModel dtmEnseign=new  DefaultTableModel();
		tableEnseign = new JTable();
		scrollPanelEnseign = new JScrollPane();
		scrollPanelEnseign.setBounds(344, 51, 385, 163);
		scrollPanelEnseign.setViewportView(tableEnseign);
		contentPane.add(scrollPanelEnseign);
		dtmEnseign.addColumn("Matricule");
		dtmEnseign.addColumn("Nom");
		dtmEnseign.addColumn("Contact");
		dtmEnseign.addRow(new Object[]{"123","angham","25588933"});
		tableEnseign.setModel(dtmEnseign);
		
		
	
		
		//Table cours
		DefaultTableModel dtmCours=new  DefaultTableModel();
		tableCours = new JTable();
		scrollPanelCours = new JScrollPane();
		scrollPanelCours.setBounds(251, 267, 478, 163);
		scrollPanelCours.setViewportView(tableCours);
		contentPane.add(scrollPanelCours);
		dtmCours.addColumn("Classe");
		dtmCours.addColumn("Matiere");
		dtmCours.addColumn("Jour");
		dtmCours.addColumn("Heure");
		dtmCours.addColumn("Enseignant");
		tableCours.setModel(dtmCours);
		
		JButton retourMenuBtn = new JButton("⬅  Retourner Au Menu");
		retourMenuBtn.setToolTipText("Retourner à la page d'accueil");
		retourMenuBtn.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		retourMenuBtn.setForeground(new Color(255, 255, 255));
		retourMenuBtn.setBackground(new Color(3, 129, 3));
		retourMenuBtn.setBounds(260, 10, 203, 21);
		retourMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame menu=new MenuFrame();
				menu.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(retourMenuBtn);
		
		JButton enregistrerCoursBtn = new JButton("ENREGISTRER");
		enregistrerCoursBtn.setToolTipText("Ajouter cours");
		enregistrerCoursBtn.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		enregistrerCoursBtn.setBackground(new Color(209, 255, 189));
		enregistrerCoursBtn.setBounds(39, 416, 132, 21);
		enregistrerCoursBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(classeBox.getSelectedItem().equals(" ") || matiereTF.getText().length()==0 || JourBox.getSelectedItem().equals(" ") || heureBox.getSelectedItem().equals(" ")|| matriculeEnseignTF.getText().length()==0) {
					String errorMsgAddCours="Une information essentielle est manquante pour procéder à l'ajout du cours. Veuillez fournir toutes les données nécessaires.";
					JOptionPane.showMessageDialog(null,errorMsgAddCours,null,JOptionPane.ERROR_MESSAGE);

				}else {
					//TODO : add cours
				}
			}
		});
		
		contentPane.add(enregistrerCoursBtn);
		
		JButton requetesBtn = new JButton("REQUETES  -->");
		requetesBtn.setToolTipText("Aller à la page des séances");
		requetesBtn.setFont(new Font("Yu Gothic", Font.BOLD, 10));
		requetesBtn.setBackground(new Color(209, 255, 189));
		requetesBtn.setBounds(39, 447, 132, 21);
		requetesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RequetesFrame req=new RequetesFrame();
				req.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(requetesBtn);
		
		JButton deconnecterBtn = new JButton("Se déconnecter");
		deconnecterBtn.setForeground(Color.WHITE);
		deconnecterBtn.setFont(new Font("Tahoma", Font.PLAIN, 7));
		deconnecterBtn.setBackground(new Color(3, 129, 3));
		deconnecterBtn.setBounds(657, 8, 85, 21);
		deconnecterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame login=new LoginFrame();
				login.setVisible(true);
				setVisible(false);
				JOptionPane.showMessageDialog(null,"Vous êtes déconnecté.",null,JOptionPane.INFORMATION_MESSAGE);	
		}
	});
		contentPane.add(deconnecterBtn);
	}
}
