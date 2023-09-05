import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class gui03 {
    private static String selectedOption = ""; // No default selected option

    public static void main(String[] args) {
        Estrutct Est = new Estrutct();
        ArrayList<TimePrimInse> ti = new ArrayList<>();
        ArrayList<TempGrafic> tenpindv = new ArrayList<>();
        String arqui = "C:\\Users\\koke2\\3D Objects\\Estrutura de Dados\\leipzig100k.txt";//substituir o caminho do arquivo aqui.
        // Colocar um seletor para saber em qual tipo de função eu irei realizar as operações
        int totalWords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dividindo a linha em palavras
                totalWords += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        final String[] wordsArray = new String[totalWords];
        long startTime = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordsArray[index] = word;
                    index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();// depois eu adiciono como pegar o tempo
        long timevecto = endTime - startTime;//time do vetor
        Est.vetor = wordsArray;
        TimePrimInse tempo = new TimePrimInse(timevecto,"Vetor");
        ti.add(tempo);
        /////////////////////////////////////////////////////////////////////////////// arraylist VVVVVV
        ArrayList<String> wordsListarr = new ArrayList<>();
        long startTimear = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dividindo a linha em palavras
                Collections.addAll(wordsListarr, words);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimear = System.nanoTime();
        long timevectoar = endTimear - startTimear;//time do arraylist
        Est.Array = wordsListarr;
        TimePrimInse tempoA = new TimePrimInse(timevectoar,"Array");
        ti.add(tempoA);
        //////////////////////////////////////////////////////////////////arraylist^^^^^^^^^^^^
        ///////////////////////////////linked list VVVVVVVVVVVVVVVVVV
        LinkedList<String> wordsLinkedList = new LinkedList<>();
        long startTimelk = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dividindo a linha em palavras
                wordsLinkedList.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimelk = System.nanoTime();
        long durationlk = endTimelk - startTimelk;
        Est.linked = wordsLinkedList;
        TimePrimInse tempolk = new TimePrimInse(durationlk,"LinkedList");
        ti.add(tempolk);
        ///////////////////////////////linked list^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //////////HashSetVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
        HashSet<String> wordsHashSet = new HashSet<>();
        long startTimeh = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dividindo a linha em palavras
                wordsHashSet.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimeh = System.nanoTime();
        long durationh = endTimeh - startTimeh;
        Est.Hasheti = wordsHashSet;
        TimePrimInse tempoh = new TimePrimInse(durationh,"HashSet");
        ti.add(tempoh);
        /////////////////////////Hashset^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        //////////////////////////LinkedHashSet////////////////////////////////////////
        LinkedHashSet<String> wordsLinkedHashSet = new LinkedHashSet<>();
        long startTimelh = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dividindo a linha em palavras
                wordsLinkedHashSet.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimelh = System.nanoTime();
        long durationlh = endTimelh - startTimelh;
        Est.lnkedHset = wordsLinkedHashSet;
        TimePrimInse tempolh = new TimePrimInse(durationlh,"LinkedHashSet");
        ti.add(tempolh);
        //////////////////////////LinkedHashSet////////////////////////////////////////
        //VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV TreeSetvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
        TreeSet<String> wordsTreeSet = new TreeSet<>();
        long startTimet = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dividindo a linha em palavras
                wordsTreeSet.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimet = System.nanoTime();
        long durationt = endTimet - startTimet;
        Est.TreeS = wordsTreeSet;
        TimePrimInse tempot = new TimePrimInse(durationt,"TreeSet");
        ti.add(tempot);
        //////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////HashMap////////////////////////////////////////////////////
        HashMap<String, String> wordMap = new HashMap<>();
        long startTimehm = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dividindo a linha em palavras
                for (String word : words) {
                    wordMap.put(word, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimehm = System.nanoTime();
        long durationhm = endTimehm - startTimehm;
        Est.hashMap = wordMap;
        TimePrimInse tempohm = new TimePrimInse(durationhm,"HashMap");
        ti.add(tempohm);
        /////////////////////////////////////^^^^^^^^^^^^^^^^^^^^/////////////////////////////////////////////
        ////////////////////////////////////LinkedHashMap/////////////////////////////////////////////////////
        LinkedHashMap<String, String> wordLinkedMap = new LinkedHashMap<>();
        long startTimelhm = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dividindo a linha em palavras
                for (String word : words) {
                    wordLinkedMap.put(word, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimelhm = System.nanoTime();
        long durationlhm = endTimelhm - startTimelhm;
        Est.linkedhshimap = wordLinkedMap;
        TimePrimInse tempolhm = new TimePrimInse(durationlhm,"LinkedHashMap");
        ti.add(tempolhm);
        ///////////////////////////////////////TreeMap///////////////////////////////////////////////////////
        ///////////////////vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv////////////////////////////////
        TreeMap<String, String> wordTreeMap = new TreeMap<>();
        long startTimetm = System.nanoTime();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqui))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dividindo a linha em palavras
                for (String word : words) {
                    wordTreeMap.put(word, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimetm = System.nanoTime();
        long durationtm = endTimetm - startTimetm;
        Est.TreeM = wordTreeMap;
        TimePrimInse tempotm = new TimePrimInse(durationtm,"TreeMap");
        ti.add(tempotm);
        /////////////////////////////////////////////////^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^///////////////////
        openPreviousScreen(Est,ti,tenpindv);
    }

    private static void openPreviousScreen(Estrutct Est,ArrayList<TimePrimInse> ti,ArrayList<TempGrafic> tempG) {
        String i = "inserir";
        String b = "buscar";
        String r = "remover";
        String v = "Vetor";
        String l = "LinkedList";
        String a = "Arraylist";
        String hs ="HashSet";
        String lhs = "LinkedHashSet";
        String ts = "TreeSet";
        String hm = "HashMap";
        String lhm = "LinkedHashMap";
        String tm = "TreeMap";
        JFrame frame = new JFrame("Estrutura de Dados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setSize(600, 400); // Aumentei a altura para acomodar o gráfico
        frame.setLayout(new BorderLayout());
        JPanel radioPanel = new JPanel(new GridLayout(9, 1));
        JPanel leftPanel = new JPanel(new BorderLayout()); // Panel for options
        JPanel rightPanel = new JPanel(new BorderLayout()); // Panel for graph

        JLabel label = new JLabel("Selecione uma opção:");
        JRadioButton optionA = new JRadioButton("<ArrayList>");
        JRadioButton optionB = new JRadioButton("<Vetor>");
        JRadioButton optionC = new JRadioButton("<Linkedlist>");
        JRadioButton optionD = new JRadioButton("<HashSet>");
        JRadioButton optionE = new JRadioButton("<LinkedHashSet>");
        JRadioButton optionF = new JRadioButton("<TreeSet>");
        JRadioButton optionG = new JRadioButton("<HashMap>");
        JRadioButton optionH = new JRadioButton("<LinkedHashMap>");
        JRadioButton optionI = new JRadioButton("<TreeMap>");
        radioPanel.add(label);
        radioPanel.add(optionA);
        radioPanel.add(optionB);
        radioPanel.add(optionC);
        radioPanel.add(optionD);
        radioPanel.add(optionE);
        radioPanel.add(optionF);
        radioPanel.add(optionG);
        radioPanel.add(optionH);
        radioPanel.add(optionI);
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(280, 110, 80, 20);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton generateGraphButton = new JButton("Inserção do Arquivo");
        buttonPanel.add(generateGraphButton);
        buttonPanel.add(nextButton);
        JPanel graphButtonPanel = new JPanel(); // Panel for graph generation buttons
        graphButtonPanel.setLayout(new BoxLayout(graphButtonPanel, BoxLayout.Y_AXIS));

        generateGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for(TimePrimInse t : ti){
                    dataset.addValue(t.tempoexec, t.Nameestru, t.Nameestru);
                }
                JFreeChart chart = ChartFactory.createBarChart(
                        "Gráfico desempenho das estruturas",
                        "Estruturas de dados",
                        "tempo(nanossegundos)",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false
                );

                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new Dimension(500, 400));

                rightPanel.removeAll(); // Remove previous components
                rightPanel.add(chartPanel, BorderLayout.CENTER); // Add the chart to the right panel
                rightPanel.revalidate(); // Refresh the layout
                rightPanel.repaint(); // Repaint the panel
            }
        });
        JButton generateSecondGraphButton = new JButton("Gráfico Inserção");
        generateSecondGraphButton.setPreferredSize(new Dimension(150,30));
        generateSecondGraphButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Align button in the center
        graphButtonPanel.add(generateSecondGraphButton);

        generateSecondGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 1;
                int xi = 1;
                int xii =1;
                int xiv =1;
                int xl = 1;
                int xt = 1;
                int th = 1;
                int lhj =1;
                int tmi =1;
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (TempGrafic t : tempG ){
                    if(t.Nomeestrut.equals(a) && t.opc.equals(i)){
                        dataset.addValue(t.inserir, t.Nomeestrut,"Inserção"+ x );
                        x++;
                    }
                    if(t.Nomeestrut.equals(v) && t.opc.equals(i)){
                        dataset.addValue(t.inserir, t.Nomeestrut,"Inserção"+ xi );
                        xi++;
                    }
                    if(t.Nomeestrut.equals(l) && t.opc.equals(i)){
                        dataset.addValue(t.inserir, t.Nomeestrut,"Inserção"+ xii );
                        xii++;
                    }
                    if(t.Nomeestrut.equals(hs) && t.opc.equals(i)){
                        dataset.addValue(t.inserir, t.Nomeestrut,"Inserção"+ xiv );
                        xiv++;
                    }
                    if(t.Nomeestrut.equals(lhs) && t.opc.equals(i)){
                        dataset.addValue(t.inserir, t.Nomeestrut,"Inserção"+ xl );
                        xl++;
                    }
                    if(t.Nomeestrut.equals(ts) && t.opc.equals(i)){
                        dataset.addValue(t.inserir, t.Nomeestrut,"Inserção"+ xt );
                        xt++;
                    }
                    if(t.Nomeestrut.equals(hm) && t.opc.equals(i)){
                        dataset.addValue(t.inserir, t.Nomeestrut,"Inserção"+ th );
                        th++;
                    }
                    if(t.Nomeestrut.equals(lhm) && t.opc.equals(i)){
                        dataset.addValue(t.inserir, t.Nomeestrut,"Inserção"+ lhj );
                        lhj++;
                    }
                    if(t.Nomeestrut.equals(tm) && t.opc.equals(i)){
                        dataset.addValue(t.inserir, t.Nomeestrut,"Inserção"+ tmi );
                        tmi++;
                    }
                }
                JFreeChart chart = ChartFactory.createLineChart(
                        "Gráfico de Inserção",
                        "Estruturas",
                        "Tempo(nanossegundos)",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false
                );

                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new Dimension(500, 400));

                rightPanel.removeAll(); // Remove previous components
                rightPanel.add(chartPanel, BorderLayout.CENTER); // Add the chart to the right panel
                rightPanel.revalidate(); // Refresh the layout
                rightPanel.repaint(); // Repaint the panel
            }
        });

        JButton generateThirdGraphButton = new JButton("Gráfico de Busca");
        generateThirdGraphButton.setPreferredSize(new Dimension(150,30));
        generateThirdGraphButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Align button in the center
        graphButtonPanel.add(generateThirdGraphButton);

        generateThirdGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                int x = 1;
                int xi = 1;
                int xii =1;
                int xiv =1;
                int xl = 1;
                int xt = 1;
                int th = 1;
                int lhj =1;
                int tmi =1;
                for (TempGrafic t : tempG ){
                    if(t.Nomeestrut.equals(a) && t.opc.equals(b)){
                        dataset.addValue(t.buscar, t.Nomeestrut,"Busca"+ x );
                        x++;
                    }
                    if(t.Nomeestrut.equals(v) && t.opc.equals(b)){
                        dataset.addValue(t.buscar, t.Nomeestrut,"Busca"+ xi );
                        xi++;
                    }
                    if(t.Nomeestrut.equals(l) && t.opc.equals(b)){
                        dataset.addValue(t.buscar, t.Nomeestrut,"Busca"+ xii );
                        xii++;
                    }
                    if(t.Nomeestrut.equals(hs) && t.opc.equals(b)){
                        dataset.addValue(t.buscar, t.Nomeestrut,"Busca"+ xiv );
                        xiv++;
                    }
                    if(t.Nomeestrut.equals(lhs) && t.opc.equals(b)){
                        dataset.addValue(t.buscar, t.Nomeestrut,"Busca"+ xl );
                        xl++;
                    }
                    if(t.Nomeestrut.equals(ts) && t.opc.equals(b)){
                        dataset.addValue(t.buscar, t.Nomeestrut,"Busca"+ xt );
                        xt++;
                    }
                    if(t.Nomeestrut.equals(hm) && t.opc.equals(b)){
                        dataset.addValue(t.buscar, t.Nomeestrut,"Busca"+ th );
                        th++;
                    }
                    if(t.Nomeestrut.equals(lhm) && t.opc.equals(b)){
                        dataset.addValue(t.buscar, t.Nomeestrut,"Busca"+ lhj );
                        lhj++;
                    }
                    if(t.Nomeestrut.equals(tm) && t.opc.equals(b)){
                        dataset.addValue(t.buscar, t.Nomeestrut,"Busca"+ tmi );
                        tmi++;
                    }
                }
                JFreeChart chart = ChartFactory.createLineChart(
                        "Gráfico de Busca",
                        "Estruturas",
                        "Tempo(nanossegundos)",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false
                );

                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new Dimension(500, 400));

                rightPanel.removeAll(); // Remove previous components
                rightPanel.add(chartPanel, BorderLayout.CENTER); // Add the chart to the right panel
                rightPanel.revalidate(); // Refresh the layout
                rightPanel.repaint(); // Repaint the panel
            }
        });
        JButton generateAnotherGraphButton = new JButton("Gráfico de Exclusão");
        generateAnotherGraphButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Align button in the center
        graphButtonPanel.add(generateAnotherGraphButton);

        generateAnotherGraphButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                int x = 1;
                int xi = 1;
                int xii =1;
                int xiv =1;
                int xl = 1;
                int xt = 1;
                int th = 1;
                int lhj =1;
                int tmi =1;
                for (TempGrafic t : tempG ){
                    if(t.Nomeestrut.equals(a) && t.opc.equals(r)){
                        dataset.addValue(t.excluir, t.Nomeestrut,"remoção"+ x );
                        x++;
                    }
                    if(t.Nomeestrut.equals(v) && t.opc.equals(r)){
                        dataset.addValue(t.excluir, t.Nomeestrut,"remoção"+ xi );
                        xi++;
                    }
                    if(t.Nomeestrut.equals(l) && t.opc.equals(r)){
                        dataset.addValue(t.excluir, t.Nomeestrut,"remoção"+ xii );
                        xii++;
                    }
                    if(t.Nomeestrut.equals(hs) && t.opc.equals(r)){
                        dataset.addValue(t.excluir, t.Nomeestrut,"remoção"+ xiv );
                        xiv++;
                    }
                    if(t.Nomeestrut.equals(lhs) && t.opc.equals(r)){
                        dataset.addValue(t.excluir, t.Nomeestrut,"remoção"+ xl );
                        xl++;
                    }
                    if(t.Nomeestrut.equals(ts) && t.opc.equals(r)){
                        dataset.addValue(t.excluir, t.Nomeestrut,"remoção"+ xt );
                        xt++;
                    }
                    if(t.Nomeestrut.equals(hm) && t.opc.equals(r)){
                        dataset.addValue(t.excluir, t.Nomeestrut,"remoção"+ th );
                        th++;
                    }
                    if(t.Nomeestrut.equals(lhm) && t.opc.equals(r)){
                        dataset.addValue(t.excluir, t.Nomeestrut,"remoção"+ lhj );
                        lhj++;
                    }
                    if(t.Nomeestrut.equals(tm) && t.opc.equals(r)){
                        dataset.addValue(t.excluir, t.Nomeestrut,"remoção"+ tmi );
                        tmi++;
                    }
                }
                JFreeChart chart = ChartFactory.createLineChart(
                        "Gráfico de Exclusão",
                        "Estruturas",
                        "Tempo(nanossegundos)",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false
                );

                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new Dimension(500, 400));

                rightPanel.removeAll(); // Remove previous components
                rightPanel.add(chartPanel, BorderLayout.CENTER); // Add the chart to the right panel
                rightPanel.revalidate(); // Refresh the layout
                rightPanel.repaint(); // Repaint the panel
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (optionA.isSelected()) {
                    selectedOption = "A";
                } else if (optionB.isSelected()) {
                    selectedOption = "B";
                } else if (optionC.isSelected()) {
                    selectedOption = "C";
                } else if (optionD.isSelected()) {
                    selectedOption = "D";
                }else if (optionE.isSelected()) {
                    selectedOption = "E";
                }else if (optionF.isSelected()) {
                    selectedOption = "F";
                }else if (optionG.isSelected()) {
                    selectedOption = "G";
                }else if (optionH.isSelected()) {
                    selectedOption = "H";
                }else if (optionI.isSelected()) {
                    selectedOption = "I";
                }else {
                    JOptionPane.showMessageDialog(frame, "Por favor selecione uma opção válida par avançar!!!.");
                    return;
                }
                frame.dispose();  // Close the previous screen
                openCurrentScreen(selectedOption, Est,ti,tempG);
            }
        });
        buttonPanel.add(graphButtonPanel);
        buttonPanel.add(generateGraphButton);
        buttonPanel.add(nextButton);
        leftPanel.add(radioPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(rightPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void openCurrentScreen(String selectedOption, Estrutct est,ArrayList<TimePrimInse> tiv,ArrayList<TempGrafic> temp) {
        String i = "inserir";
        String b = "buscar";
        String r = "remover";
        String v = "Vetor";
        String l = "LinkedList";
        String a = "Arraylist";
        String hs ="HashSet";
        String lhs = "LinkedHashSet";
        String ts = "TreeSet";
        String hm = "HashMap";
        String lhm = "LinkedHashMap";
        String tm = "TreeMap";
        JFrame frame = new JFrame("Operações na Estrutura:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);//tamanho da janelinha irru
        frame.setLayout(null);
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(20, 110, 340, 20);
        switch (selectedOption) {
            case "A":
                JLabel insertLabel = new JLabel("Inserir palavra:");
                insertLabel.setBounds(20, 20, 100, 20);
                JTextField insertField = new JTextField();
                insertField.setBounds(120, 20, 150, 20);
                JButton insertButton = new JButton("Insert");
                insertButton.setBounds(280, 20, 80, 20);

                JLabel searchLabel = new JLabel("Buscar palavra:");
                searchLabel.setBounds(20, 50, 100, 20);
                JTextField searchField = new JTextField();
                searchField.setBounds(120, 50, 150, 20);
                JButton searchButton = new JButton("Search");
                searchButton.setBounds(280, 50, 80, 20);

                JLabel removeLabel = new JLabel("Remover palavra:");
                removeLabel.setBounds(20, 80, 100, 20);
                JTextField removeField = new JTextField();
                removeField.setBounds(120, 80, 150, 20);
                JButton removeButton = new JButton("Remove");
                removeButton.setBounds(280, 80, 80, 20);

                JButton returnButton = new JButton("Voltar");
                returnButton.setBounds(280, 110, 80, 20);
                insertButton.addActionListener(new ActionListener() {//não tem tratamento para string vazia
                    public void actionPerformed(ActionEvent e) {//falta atualizar o tempo nos gráficos
                        String word = insertField.getText();
                        Remendo result = Javacollect.insertWordarr(est.Array, word);
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = a;
                        n.inserir = result.tempo;
                        n.opc = i;
                        temp.add(n);
                        resultLabel.setText("Inserted word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        est.Array = result.s;
                    }
                });
                // ActionListener for searchButton
                searchButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String word = searchField.getText();
                        Remendo result = Javacollect.searchWordarr(est.Array, word);
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = a;
                        n.buscar = result.tempo;
                        n.opc = b;
                        temp.add(n);
                        resultLabel.setText("Word found: " + result.found + " " + result.palavr + " in " + result.tempo + " nanoseconds.");
                    }
                });

                // ActionListener for removeButton
                removeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//erro de palavra inexistente exception sla ou if
                        String word = removeField.getText();//pegar o found aki
                        Remendo result = Javacollect.removeWordarr(est.Array, word);
                        resultLabel.setText("Removed word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = a;
                        n.excluir = result.tempo;
                        n.opc = r;
                        temp.add(n);
                        est.Array = result.s;
                    }
                });
                returnButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Feche a tela atual
                        openPreviousScreen(est,tiv,temp);   // Abra a tela anterior novamente
                    }
                });

                frame.add(insertLabel);
                frame.add(insertField);
                frame.add(insertButton);
                frame.add(searchLabel);
                frame.add(searchField);
                frame.add(searchButton);
                frame.add(removeLabel);
                frame.add(removeField);
                frame.add(removeButton);
                frame.add(resultLabel);
                frame.add(returnButton);
                frame.setVisible(true);
                break;
            case "B":
                JLabel insertLabe = new JLabel("Inserir palavra:");
                insertLabe.setBounds(20, 20, 100, 20);
                JTextField insertFiel = new JTextField();
                insertFiel.setBounds(120, 20, 150, 20);
                JButton insertButto = new JButton("Insert");
                insertButto.setBounds(280, 20, 80, 20);

                JLabel searchLabe = new JLabel("Buscar palavra:");
                searchLabe.setBounds(20, 50, 100, 20);
                JTextField searchFiel = new JTextField();
                searchFiel.setBounds(120, 50, 150, 20);
                JButton searchButto = new JButton("Search");
                searchButto.setBounds(280, 50, 80, 20);

                JLabel removeLabe = new JLabel("Remover palavra:");
                removeLabe.setBounds(20, 80, 100, 20);
                JTextField removeFiel = new JTextField();
                removeFiel.setBounds(120, 80, 150, 20);
                JButton removeButto = new JButton("Remove");
                removeButto.setBounds(280, 80, 80, 20);

                JButton returnButto = new JButton("Voltar");
                returnButto.setBounds(280, 110, 80, 20);
                insertButto.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//falta atualizar o tempo nos gráficos
                        String word = insertFiel.getText();
                        Remendo result = Javacollect.insertWord(est.vetor, word);
                        resultLabel.setText("Inserted word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        est.vetor = result.vet;
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = v;
                        n.inserir = result.tempo;
                        n.opc = i;
                        temp.add(n);
                    }
                });
                // ActionListener for searchButton
                searchButto.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String word = searchFiel.getText();
                        Remendo result = Javacollect.searchWord(est.vetor, word);
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = v;
                        n.buscar = result.tempo;
                        n.opc = b;
                        temp.add(n);
                        resultLabel.setText("Word found: " + result.found + " " + result.palavr + " in " + result.tempo + " nanoseconds.");
                    }
                });

                // ActionListener for removeButton
                removeButto.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//erro de palavra inexistente
                        String word = removeFiel.getText();//pegar o found aki
                        Remendo result = Javacollect.removeWord(est.vetor, word);
                        resultLabel.setText("Removed word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = v;
                        n.excluir = result.tempo;
                        n.opc = r;
                        temp.add(n);
                        est.vetor= result.vet;
                    }
                });
                returnButto.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Feche a tela atual
                        openPreviousScreen(est,tiv,temp);   // Abra a tela anterior novamente
                    }
                });

                frame.add(insertLabe);
                frame.add(insertFiel);
                frame.add(insertButto);
                frame.add(searchLabe);
                frame.add(searchFiel);
                frame.add(searchButto);
                frame.add(removeLabe);
                frame.add(removeFiel);
                frame.add(removeButto);
                frame.add(returnButto);
                frame.add(resultLabel);
                frame.setVisible(true);
                break;
            case "C":
                JLabel insertLab = new JLabel("Inserir palavra:");
                insertLab.setBounds(20, 20, 100, 20);
                JTextField insertFie = new JTextField();
                insertFie.setBounds(120, 20, 150, 20);
                JButton insertButt = new JButton("Insert");
                insertButt.setBounds(280, 20, 80, 20);

                JLabel searchLab = new JLabel("Buscar palavra:");
                searchLab.setBounds(20, 50, 100, 20);
                JTextField searchFie = new JTextField();
                searchFie.setBounds(120, 50, 150, 20);
                JButton searchButt = new JButton("Search");
                searchButt.setBounds(280, 50, 80, 20);

                JLabel removeLab = new JLabel("Remover palavra:");
                removeLab.setBounds(20, 80, 100, 20);
                JTextField removeFie = new JTextField();
                removeFie.setBounds(120, 80, 150, 20);
                JButton removeButt = new JButton("Remove");
                removeButt.setBounds(280, 80, 80, 20);

                JButton returnButt = new JButton("Voltar");
                returnButt.setBounds(280, 110, 80, 20);
                insertButt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//falta atualizar o tempo nos gráficos
                        String word = insertFie.getText();
                        Remendo result = Javacollect.insertWordLink(est.linked, word);
                        resultLabel.setText("Inserted word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = l;
                        n.inserir = result.tempo;
                        n.opc = i;
                        temp.add(n);

                        est.linked = result.link;
                    }
                });
                // ActionListener for searchButton
                searchButt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String word = searchFie.getText();
                        Remendo result = Javacollect.searchWordLink(est.linked, word);
                        resultLabel.setText("Word found: " + result.found + " " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = l;
                        n.buscar = result.tempo;
                        n.opc = b;
                        temp.add(n);
                    }
                });

                // ActionListener for removeButton
                removeButt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//erro de palavra inexistente
                        String word = removeFie.getText();//pegar o found aki
                        Remendo result = Javacollect.removeWordLink(est.linked, word);
                        resultLabel.setText("Removed word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = l;
                        n.excluir = result.tempo;
                        n.opc = r;
                        temp.add(n);
                        est.linked= result.link;
                    }
                });
                returnButt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Feche a tela atual
                        openPreviousScreen(est,tiv,temp);   // Abra a tela anterior novamente
                    }
                });

                frame.add(insertLab);
                frame.add(insertFie);
                frame.add(insertButt);
                frame.add(searchLab);
                frame.add(searchFie);
                frame.add(searchButt);
                frame.add(removeLab);
                frame.add(removeFie);
                frame.add(removeButt);
                frame.add(returnButt);
                frame.add(resultLabel);
                frame.setVisible(true);
                break;
            case "D":
                JLabel insertLa = new JLabel("Inserir palavra:");
                insertLa.setBounds(20, 20, 100, 20);
                JTextField insertFi = new JTextField();
                insertFi.setBounds(120, 20, 150, 20);
                JButton insertBut = new JButton("Insert");
                insertBut.setBounds(280, 20, 80, 20);

                JLabel searchLa = new JLabel("Buscar palavra:");
                searchLa.setBounds(20, 50, 100, 20);
                JTextField searchFi = new JTextField();
                searchFi.setBounds(120, 50, 150, 20);
                JButton searchBut = new JButton("Search");
                searchBut.setBounds(280, 50, 80, 20);

                JLabel removeLa = new JLabel("Remover palavra:");
                removeLa.setBounds(20, 80, 100, 20);
                JTextField removeFi = new JTextField();
                removeFi.setBounds(120, 80, 150, 20);
                JButton removeBut = new JButton("Remove");
                removeBut.setBounds(280, 80, 80, 20);

                JButton returnBut = new JButton("Voltar");
                returnBut.setBounds(280, 110, 80, 20);
                insertBut.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//falta atualizar o tempo nos gráficos
                        String word = insertFi.getText();
                        Remendo result = Javacollect.insertWordHashSet(est.Hasheti, word);
                        resultLabel.setText("Inserted word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = hs;
                        n.inserir = result.tempo;
                        n.opc = i;
                        temp.add(n);

                        est.Hasheti = result.hasSeti;
                    }
                });
                // ActionListener for searchButton
                searchBut.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String word = searchFi.getText();
                        Remendo result = Javacollect.searchWordHashSet(est.Hasheti, word);
                        resultLabel.setText("Word found: " + result.found + " " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = hs;
                        n.buscar = result.tempo;
                        n.opc = b;
                        temp.add(n);
                    }
                });

                // ActionListener for removeButton
                removeBut.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//erro de palavra inexistente
                        String word = removeFi.getText();//pegar o found aki
                        Remendo result = Javacollect.removeWordHashSet(est.Hasheti, word);
                        resultLabel.setText("Removed word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = hs;
                        n.excluir = result.tempo;
                        n.opc = r;
                        temp.add(n);
                        est.Hasheti = result.hasSeti;
                    }
                });
                returnBut.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Feche a tela atual
                        openPreviousScreen(est,tiv,temp);   // Abra a tela anterior novamente
                    }
                });

                frame.add(insertLa);
                frame.add(insertFi);
                frame.add(insertBut);
                frame.add(searchLa);
                frame.add(searchFi);
                frame.add(searchBut);
                frame.add(removeLa);
                frame.add(removeFi);
                frame.add(removeBut);
                frame.add(returnBut);
                frame.add(resultLabel);
                frame.setVisible(true);

                break;
            case "E":
                JLabel insertL = new JLabel("Inserir palavra:");
                insertL.setBounds(20, 20, 100, 20);
                JTextField insertF = new JTextField();
                insertF.setBounds(120, 20, 150, 20);
                JButton insertBu = new JButton("Insert");
                insertBu.setBounds(280, 20, 80, 20);

                JLabel searchL = new JLabel("Buscar palavra:");
                searchL.setBounds(20, 50, 100, 20);
                JTextField searchF = new JTextField();
                searchF.setBounds(120, 50, 150, 20);
                JButton searchBu = new JButton("Search");
                searchBu.setBounds(280, 50, 80, 20);

                JLabel removeL = new JLabel("Remover palavra:");
                removeL.setBounds(20, 80, 100, 20);
                JTextField removeF = new JTextField();
                removeF.setBounds(120, 80, 150, 20);
                JButton removeBu = new JButton("Remove");
                removeBu.setBounds(280, 80, 80, 20);

                JButton returnBu = new JButton("Voltar");
                returnBu.setBounds(280, 110, 80, 20);
                insertBu.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//falta atualizar o tempo nos gráficos
                        String word = insertF.getText();
                        Remendo result = Javacollect.insertWordLinkedHashSet(est.lnkedHset, word);
                        resultLabel.setText("Inserted word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = lhs;
                        n.inserir = result.tempo;
                        n.opc = i;
                        temp.add(n);
                        est.lnkedHset = result.linkHseti;
                    }
                });
                // ActionListener for searchButton
                searchBu.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String word = searchF.getText();
                        Remendo result = Javacollect.searchWordLinkedHashSet(est.lnkedHset, word);
                        resultLabel.setText("Word found: " + result.found + " " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = lhs;
                        n.buscar = result.tempo;
                        n.opc = b;
                        temp.add(n);
                    }
                });

                // ActionListener for removeButton
                removeBu.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//erro de palavra inexistente
                        String word = removeF.getText();//pegar o found aki
                        Remendo result = Javacollect.removeWordLinkedHashSet(est.lnkedHset, word);
                        resultLabel.setText("Removed word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = lhs;
                        n.excluir = result.tempo;
                        n.opc = r;
                        temp.add(n);
                        est.lnkedHset = result.linkHseti;
                    }
                });
                returnBu.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Feche a tela atual
                        openPreviousScreen(est,tiv,temp);   // Abra a tela anterior novamente
                    }
                });

                frame.add(insertL);
                frame.add(insertF);
                frame.add(insertBu);
                frame.add(searchL);
                frame.add(searchF);
                frame.add(searchBu);
                frame.add(removeL);
                frame.add(removeF);
                frame.add(removeBu);
                frame.add(returnBu);
                frame.add(resultLabel);
                frame.setVisible(true);

                break;
            case "F":
                JLabel inserti = new JLabel("Inserir palavra:");
                inserti.setBounds(20, 20, 100, 20);
                JTextField inserf = new JTextField();
                inserf.setBounds(120, 20, 150, 20);
                JButton insertB = new JButton("Insert");
                insertB.setBounds(280, 20, 80, 20);

                JLabel search = new JLabel("Buscar palavra:");
                search.setBounds(20, 50, 100, 20);
                JTextField searc = new JTextField();
                searc.setBounds(120, 50, 150, 20);
                JButton searchB = new JButton("Search");
                searchB.setBounds(280, 50, 80, 20);

                JLabel remove = new JLabel("Remover palavra:");
                remove.setBounds(20, 80, 100, 20);
                JTextField remov = new JTextField();
                remov.setBounds(120, 80, 150, 20);
                JButton removeB = new JButton("Remove");
                removeB.setBounds(280, 80, 80, 20);

                JButton returnB = new JButton("Voltar");
                returnB.setBounds(280, 110, 80, 20);
                insertB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//falta atualizar o tempo nos gráficos
                        String word = inserf.getText();
                        Remendo result = Javacollect.insertWordTreeSet(est.TreeS, word);
                        resultLabel.setText("Inserted word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = ts;
                        n.inserir = result.tempo;
                        n.opc = i;
                        temp.add(n);
                        est.TreeS = result.triiseti;
                    }
                });
                // ActionListener for searchButton
                searchB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String word = searc.getText();
                        Remendo result = Javacollect.searchWordTreeSet(est.TreeS, word);
                        resultLabel.setText("Word found: " + result.found + " " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = ts;
                        n.buscar = result.tempo;
                        n.opc = b;
                        temp.add(n);
                    }
                });
                // ActionListener for removeButton
                removeB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//erro de palavra inexistente
                        String word = remov.getText();//pegar o found aki
                        Remendo result = Javacollect.removeWordTreeSet(est.TreeS, word);
                        resultLabel.setText("Removed word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = ts;
                        n.excluir = result.tempo;
                        n.opc = r;
                        temp.add(n);
                        est.TreeS = result.triiseti;
                    }
                });
                returnB.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Feche a tela atual
                        openPreviousScreen(est,tiv,temp);   // Abra a tela anterior novamente
                    }
                });
                frame.add(inserti);
                frame.add(inserf);
                frame.add(insertB);
                frame.add(search);
                frame.add(searc);
                frame.add(searchB);
                frame.add(remove);
                frame.add(remov);
                frame.add(removeB);
                frame.add(returnB);
                frame.add(resultLabel);
                frame.setVisible(true);
                break;
            case "G":
                JLabel insertLabelhm = new JLabel("Inserir palavra:");
                insertLabelhm.setBounds(20, 20, 100, 20);
                JTextField insertFieldhm = new JTextField();
                insertFieldhm.setBounds(120, 20, 150, 20);
                JButton insertButtonhm = new JButton("Insert");
                insertButtonhm.setBounds(280, 20, 80, 20);

                JLabel searchLabelhm = new JLabel("Buscar palavra:");
                searchLabelhm.setBounds(20, 50, 100, 20);
                JTextField searchFieldhm = new JTextField();
                searchFieldhm.setBounds(120, 50, 150, 20);
                JButton searchButtonhm = new JButton("Search");
                searchButtonhm.setBounds(280, 50, 80, 20);

                JLabel removeLabelhm = new JLabel("Remover palavra:");
                removeLabelhm.setBounds(20, 80, 100, 20);
                JTextField removeFieldhm = new JTextField();
                removeFieldhm.setBounds(120, 80, 150, 20);
                JButton removeButtonhm = new JButton("Remove");
                removeButtonhm.setBounds(280, 80, 80, 20);

                JButton returnButtonhm = new JButton("Voltar");
                returnButtonhm.setBounds(280, 110, 80, 20);
                insertButtonhm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//falta atualizar o tempo nos gráficos
                        String word = insertFieldhm.getText();
                        Remendo result = Javacollect.insertWordHashMap(est.hashMap, word);
                        resultLabel.setText("Inserted word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = hm;
                        n.inserir = result.tempo;
                        n.opc = i;
                        temp.add(n);
                        est.hashMap = result.hashimapi;
                    }
                });
                // ActionListener for searchButton
                searchButtonhm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String word = searchFieldhm.getText();
                        Remendo result = Javacollect.searchWordHashMap(est.hashMap, word);
                        resultLabel.setText("Word found: " + result.found + " " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = v;
                        n.buscar = result.tempo;
                        n.opc = b;
                        temp.add(n);
                    }
                });

                // ActionListener for removeButton
                removeButtonhm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//erro de palavra inexistente exception sla ou if
                        String word = removeFieldhm.getText();//pegar o found aki
                        Remendo result = Javacollect.removeWordHashMap(est.hashMap, word);
                        resultLabel.setText("Removed word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = v;
                        n.excluir = result.tempo;
                        n.opc = r;
                        temp.add(n);
                        est.hashMap = result.hashimapi;
                    }
                });
                returnButtonhm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Feche a tela atual
                        openPreviousScreen(est,tiv,temp);   // Abra a tela anterior novamente
                    }
                });

                frame.add(insertLabelhm);
                frame.add(insertFieldhm);
                frame.add(insertButtonhm);
                frame.add(searchLabelhm);
                frame.add(searchFieldhm);
                frame.add(searchButtonhm);
                frame.add(removeLabelhm);
                frame.add(removeFieldhm);
                frame.add(removeButtonhm);
                frame.add(resultLabel);
                frame.add(returnButtonhm);
                frame.setVisible(true);
                break;

            case "H":
                JLabel insertLabellhm = new JLabel("Inserir palavra:");
                insertLabellhm.setBounds(20, 20, 100, 20);
                JTextField insertFieldlhm = new JTextField();
                insertFieldlhm.setBounds(120, 20, 150, 20);
                JButton insertButtonlhm = new JButton("Insert");
                insertButtonlhm.setBounds(280, 20, 80, 20);

                JLabel searchLabellhm = new JLabel("Buscar palavra:");
                searchLabellhm.setBounds(20, 50, 100, 20);
                JTextField searchFieldlhm = new JTextField();
                searchFieldlhm.setBounds(120, 50, 150, 20);
                JButton searchButtonlhm = new JButton("Search");
                searchButtonlhm.setBounds(280, 50, 80, 20);

                JLabel removeLabellhm = new JLabel("Remover palavra:");
                removeLabellhm.setBounds(20, 80, 100, 20);
                JTextField removeFieldlhm = new JTextField();
                removeFieldlhm.setBounds(120, 80, 150, 20);
                JButton removeButtonlhm = new JButton("Remove");
                removeButtonlhm.setBounds(280, 80, 80, 20);

                JButton returnButtonlhm = new JButton("Voltar");
                returnButtonlhm.setBounds(280, 110, 80, 20);
                insertButtonlhm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//falta atualizar o tempo nos gráficos
                        String word = insertFieldlhm.getText();
                        Remendo result = Javacollect.insertWordLinkedHashMap(est.linkedhshimap, word);
                        resultLabel.setText("Inserted word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = lhm;
                        n.inserir = result.tempo;
                        n.opc = i;
                        temp.add(n);
                        est.linkedhshimap = result.linkhashimapi;
                    }
                });
                // ActionListener for searchButton
                searchButtonlhm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String word = searchFieldlhm.getText();
                        Remendo result = Javacollect.searchWordLinkedHashMap(est.linkedhshimap, word);
                        resultLabel.setText("Word found: " + result.found + " " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = lhm;
                        n.buscar = result.tempo;
                        n.opc = b;
                        temp.add(n);

                    }
                });

                // ActionListener for removeButton
                removeButtonlhm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//erro de palavra inexistente exception sla ou if
                        String word = removeFieldlhm.getText();//pegar o found aki
                        Remendo result = Javacollect.removeWordLinkedHashMap(est.linkedhshimap, word);
                        resultLabel.setText("Removed word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = lhm;
                        n.excluir = result.tempo;
                        n.opc = r;
                        temp.add(n);
                        est.linkedhshimap = result.linkhashimapi;
                    }
                });
                returnButtonlhm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Feche a tela atual
                        openPreviousScreen(est,tiv,temp);   // Abra a tela anterior novamente
                    }
                });

                frame.add(insertLabellhm);
                frame.add(insertFieldlhm);
                frame.add(insertButtonlhm);
                frame.add(searchLabellhm);
                frame.add(searchFieldlhm);
                frame.add(searchButtonlhm);
                frame.add(removeLabellhm);
                frame.add(removeFieldlhm);
                frame.add(removeButtonlhm);
                frame.add(resultLabel);
                frame.add(returnButtonlhm);
                frame.setVisible(true);
                break;

            case "I":
                JLabel insertLabellthm = new JLabel("Inserir palavra:");
                insertLabellthm.setBounds(20, 20, 100, 20);
                JTextField insertFieldlthm = new JTextField();
                insertFieldlthm.setBounds(120, 20, 150, 20);
                JButton insertButtonlthm = new JButton("Insert");
                insertButtonlthm.setBounds(280, 20, 80, 20);

                JLabel searchLabellthm = new JLabel("Buscar palavra:");
                searchLabellthm.setBounds(20, 50, 100, 20);
                JTextField searchFieldlthm = new JTextField();
                searchFieldlthm.setBounds(120, 50, 150, 20);
                JButton searchButtonlthm = new JButton("Search");
                searchButtonlthm.setBounds(280, 50, 80, 20);

                JLabel removeLabellthm = new JLabel("Remover palavra:");
                removeLabellthm.setBounds(20, 80, 100, 20);
                JTextField removeFieldlthm = new JTextField();
                removeFieldlthm.setBounds(120, 80, 150, 20);
                JButton removeButtonlthm = new JButton("Remove");
                removeButtonlthm.setBounds(280, 80, 80, 20);

                JButton returnButtonlthm = new JButton("Voltar");
                returnButtonlthm.setBounds(280, 110, 80, 20);
                insertButtonlthm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//falta atualizar o tempo nos gráficos
                        String word = insertFieldlthm.getText();
                        Remendo result = Javacollect.insertWordTreeMap(est.TreeM, word);
                        resultLabel.setText("Inserted word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = tm;
                        n.inserir = result.tempo;
                        n.opc = i;
                        temp.add(n);
                        est.TreeM = result.trimapi;
                    }
                });
                // ActionListener for searchButton
                searchButtonlthm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String word = searchFieldlthm.getText();
                        Remendo result = Javacollect.searchWordTreeMap(est.TreeM, word);
                        resultLabel.setText("Word found: " + result.found + " " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = v;
                        n.buscar = result.tempo;
                        n.opc = b;
                        temp.add(n);
                    }

                });

                // ActionListener for removeButton
                removeButtonlthm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {//erro de palavra inexistente exception sla ou if
                        String word = removeFieldlthm.getText();//pegar o found aki
                        Remendo result = Javacollect.removeWordTreeMap(est.TreeM, word);
                        resultLabel.setText("Removed word: " + result.palavr + " in " + result.tempo + " nanoseconds.");
                        TempGrafic n = new TempGrafic();
                        n.Nomeestrut = tm;
                        n.excluir = result.tempo;
                        n.opc = r;
                        temp.add(n);
                        est.TreeM = result.trimapi;
                    }
                });
                returnButtonlthm.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // Feche a tela atual
                        openPreviousScreen(est,tiv,temp);   // Abra a tela anterior novamente
                    }
                });

                frame.add(insertLabellthm);
                frame.add(insertFieldlthm);
                frame.add(insertButtonlthm);
                frame.add(searchLabellthm);
                frame.add(searchFieldlthm);
                frame.add(searchButtonlthm);
                frame.add(removeLabellthm);
                frame.add(removeFieldlthm);
                frame.add(removeButtonlthm);
                frame.add(resultLabel);
                frame.add(returnButtonlthm);
                frame.setVisible(true);
                break;
        }

        frame.add(resultLabel);
        frame.setVisible(true);
    }
}

