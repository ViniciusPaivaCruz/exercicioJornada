import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelaCadastroEscala extends JFrame {
    private JTextField txtInicioPeriodo, txtFimPeriodo, txtValorHoraPeriodo;
    private JTextField txtNomeJornada, txtDescricaoJornada, txtAposJornada, txtAdicionarJornada;
    private JTextArea areaPeriodos, areaJornadas;
    private JCheckBox[] checkBoxDias;

    private ArrayList<String> periodosCriados = new ArrayList<>();
    private ArrayList<String> jornadasCriadas = new ArrayList<>();
    private ArrayList<float[]> periodos = new ArrayList<>();
    private ArrayList<Jornada> jornadas = new ArrayList<>();


    public TelaCadastroEscala() {
        setTitle("Gerenciador de Jornadas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Painel para criar períodos
        JPanel panelPeriodo = new JPanel();
        panelPeriodo.setBorder(BorderFactory.createTitledBorder("Criar Período"));
        panelPeriodo.setLayout(null);
        panelPeriodo.setBounds(20, 20, 380, 200);

        JLabel lblInicioPeriodo = new JLabel("Horário de Início:");
        lblInicioPeriodo.setBounds(20, 30, 120, 20);
        txtInicioPeriodo = new JTextField();
        txtInicioPeriodo.setBounds(150, 30, 200, 20);
        panelPeriodo.add(lblInicioPeriodo);
        panelPeriodo.add(txtInicioPeriodo);

        JLabel lblFimPeriodo = new JLabel("Horário Final:");
        lblFimPeriodo.setBounds(20, 60, 120, 20);
        txtFimPeriodo = new JTextField();
        txtFimPeriodo.setBounds(150, 60, 200, 20);
        panelPeriodo.add(lblFimPeriodo);
        panelPeriodo.add(txtFimPeriodo);

        JLabel lblValorHoraPeriodo = new JLabel("Valor da Hora:");
        lblValorHoraPeriodo.setBounds(20, 90, 120, 20);
        txtValorHoraPeriodo = new JTextField();
        txtValorHoraPeriodo.setBounds(150, 90, 200, 20);
        panelPeriodo.add(lblValorHoraPeriodo);
        panelPeriodo.add(txtValorHoraPeriodo);

        JButton btnCriarPeriodo = new JButton("Criar Período");
        btnCriarPeriodo.setBounds(150, 120, 200, 30);
        panelPeriodo.add(btnCriarPeriodo);

        panel.add(panelPeriodo);

        btnCriarPeriodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtInicioPeriodo.getText().isEmpty() || txtFimPeriodo.getText().isEmpty() || txtValorHoraPeriodo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.",
                            "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        float inicio = Float.parseFloat(txtInicioPeriodo.getText());
                        float fim = Float.parseFloat(txtFimPeriodo.getText());
                        float valorHora = Float.parseFloat(txtValorHoraPeriodo.getText());
        
                        if (inicio < 0 || fim < 0 || valorHora < 0) {
                            JOptionPane.showMessageDialog(null, "Os valores não podem ser negativos.",
                                    "Valores inválidos", JOptionPane.WARNING_MESSAGE);
                        } else {
                            System.out.println("teste");
                            if (periodos.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Período criado.",
                                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                    periodos.add(new float[]{inicio, fim, valorHora});
                                    criarPeriodo();
                            } else {
                                for (float[] periodo : periodos) {
                                    float start = periodo[0];
                                    float end = periodo[1];
                                    if (inicio < end && start < inicio) {
                                        JOptionPane.showMessageDialog(null, "Os periodos estão se convergindo.",
                                        "Valores inválidos", JOptionPane.WARNING_MESSAGE);
                                    } else if (inicio < start && end > start) {
                                        JOptionPane.showMessageDialog(null, "Os periodos estão se convergindo.",
                                        "Valores inválidos", JOptionPane.WARNING_MESSAGE);
                                    } else if (start == inicio || end == fim) {
                                        JOptionPane.showMessageDialog(null, "Os periodos estão se convergindo.",
                                        "Valores inválidos", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Período criado.",
                                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                        periodos.add(new float[]{inicio, fim, valorHora});
                                        criarPeriodo();
                                    }
                                }
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Os valores devem ser números válidos.",
                                "Valores inválidos", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        // Painel para criar jornadas
        JPanel panelJornada = new JPanel();
        panelJornada.setBorder(BorderFactory.createTitledBorder("Criar Jornada"));
        panelJornada.setLayout(null);
        panelJornada.setBounds(20, 240, 380, 200);

        JLabel lblNomeJornada = new JLabel("Nome da Jornada:");
        lblNomeJornada.setBounds(20, 30, 120, 20);
        txtNomeJornada = new JTextField();
        txtNomeJornada.setBounds(150, 30, 200, 20);
        panelJornada.add(lblNomeJornada);
        panelJornada.add(txtNomeJornada);

        JLabel lblDescricaoJornada = new JLabel("Descrição:");
        lblDescricaoJornada.setBounds(20, 60, 120, 20);
        txtDescricaoJornada = new JTextField();
        txtDescricaoJornada.setBounds(150, 60, 200, 20);
        panelJornada.add(lblDescricaoJornada);
        panelJornada.add(txtDescricaoJornada);

        JLabel lblAposJornada = new JLabel("Após");
        lblAposJornada.setBounds(20, 90, 40, 20);
        txtAposJornada = new JTextField();
        txtAposJornada.setText("0");
        txtAposJornada.setBounds(65, 90, 50, 20);
        JLabel lblAdicionarJornada = new JLabel("  adicionar");
        lblAdicionarJornada.setBounds(120, 90, 70, 20);
        txtAdicionarJornada = new JTextField();
        txtAdicionarJornada.setText("0");
        txtAdicionarJornada.setBounds(195, 90, 50, 20);
        JLabel lblHorasJornada = new JLabel("  hora(s)");
        lblHorasJornada.setBounds(250, 90, 70, 20);
        panelJornada.add(lblAposJornada);
        panelJornada.add(txtAposJornada);
        panelJornada.add(lblAdicionarJornada);
        panelJornada.add(txtAdicionarJornada);
        panelJornada.add(lblHorasJornada);

        panelJornada.add(new JLabel("Dias da Semana:"));
        String[] diasSemana = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sáb", "Dom"};
        checkBoxDias = new JCheckBox[7];
        for (int i = 0; i < 7; i++) {
            checkBoxDias[i] = new JCheckBox(diasSemana[i]);
            checkBoxDias[i].setBounds(20 + i * 50, 120, 52, 20);
            panelJornada.add(checkBoxDias[i]);
        }

        JButton btnCriarJornada = new JButton("Criar Jornada");
        btnCriarJornada.setBounds(150, 150, 200, 30);
        btnCriarJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarJornada();
            }
        });
        panelJornada.add(btnCriarJornada);

        panel.add(panelJornada);

        btnCriarJornada.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                // Verifica se os campos estão preenchidos
                if (txtNomeJornada.getText().isEmpty() || txtAposJornada.getText().isEmpty() || txtAdicionarJornada.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.",
                            "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Se os campos estiverem preenchidos, execute a ação de confirmação aqui
                    ArrayList<String> dias = new ArrayList<>();
                    for (int i = 0; i < 7; i++) {
                        if (checkBoxDias[i].isSelected()) {
                            dias.add(checkBoxDias[i].getText());
                            panelJornada.remove(checkBoxDias[i]);
                        }
                    }
                    if (dias.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha o(s) dia(s) da semana.",
                            "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (!jornadas.isEmpty()) {
                            for (Jornada jornada : jornadas) {
                                if (jornada.getNome() == txtNomeJornada.getText()) {
                                    JOptionPane.showMessageDialog(null, "Nome da jornada já utilizado.",
                                    "Campos inválidos", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                        panelJornada.revalidate();
                        panelJornada.repaint();
                        JOptionPane.showMessageDialog(null, "Jornada criada.",
                                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        Jornada novaJornada = new Jornada(periodos, txtNomeJornada.getText(), txtDescricaoJornada.getText(), dias, Float.parseFloat(txtAposJornada.getText()), Float.parseFloat(txtAdicionarJornada.getText()));
                        jornadas.add(novaJornada);
                        periodos.clear();
                    }
                }
            }
        });

        // JScrollPane dos períodos
        areaPeriodos = new JTextArea();
        JScrollPane scrollPeriodos = new JScrollPane(areaPeriodos);
        scrollPeriodos.setBorder(BorderFactory.createTitledBorder("Períodos Criados"));
        scrollPeriodos.setBounds(420, 20, 340, 200);
        panel.add(scrollPeriodos);

        // JScrollPane das jornadas
        areaJornadas = new JTextArea();
        JScrollPane scrollJornadas = new JScrollPane(areaJornadas);
        scrollJornadas.setBorder(BorderFactory.createTitledBorder("Jornadas Criadas"));
        scrollJornadas.setBounds(420, 240, 340, 200);
        panel.add(scrollJornadas);

        add(panel);
        setVisible(true);

        JButton btnCriarEscala = new JButton("Criar Escala");
        btnCriarEscala.setBounds(300, 470, 200, 30);
        btnCriarEscala.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarEscala();
            }
        });
        panel.add(btnCriarEscala);

    }

    protected void criarEscala() {
        Escala escala = new Escala();
        for (Jornada jornada : jornadas) {
            escala.adicionarJornada(jornada);
        }
    }

    private void criarPeriodo() {
        String inicio = txtInicioPeriodo.getText();
        String fim = txtFimPeriodo.getText();
        String valor = txtValorHoraPeriodo.getText();

        String periodo = "Início: " + inicio + ", Fim: " + fim + ", Valor da Hora: " + valor;
        if (!inicio.isEmpty() && !fim.isEmpty() && !valor.isEmpty()) {
            periodosCriados.add(periodo);
            atualizarAreaPeriodos();
        }
    }

    private void criarJornada() {
        StringBuilder jornada = new StringBuilder();
        jornada.append("Nome: ").append(txtNomeJornada.getText()).append(", ");
        jornada.append("Descrição: ").append(txtDescricaoJornada.getText()).append(", ");
        jornada.append("Após ").append(txtAposJornada.getText()).append(" adicionar ").append(txtAdicionarJornada.getText()).append(" hora(s), ");
        jornada.append("Dias: ");
        boolean diasCheck = false;
        for (int i = 0; i < checkBoxDias.length; i++) {
            if (checkBoxDias[i].isSelected()) {
                jornada.append(checkBoxDias[i].getText()).append(", ");
                diasCheck = true;
            }
        }
        if (!txtNomeJornada.getText().isEmpty() && !txtAposJornada.getText().isEmpty() && !txtAdicionarJornada.getText().isEmpty() && diasCheck) {
            jornadasCriadas.add(jornada.toString());
            atualizarAreaPeriodos();
            atualizarAreaJornadas();
        }
    }

    private void atualizarAreaPeriodos() {
        StringBuilder sb = new StringBuilder();
        for (String periodo : periodosCriados) {
            sb.append(periodo).append("\n");
        }
        areaPeriodos.setText(sb.toString());
    }

    private void atualizarAreaJornadas() {
        StringBuilder sb = new StringBuilder();
        for (String jornada : jornadasCriadas) {
            sb.append(jornada).append("\n");
        }
        areaJornadas.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastroEscala();
            }
        });
    }
}
