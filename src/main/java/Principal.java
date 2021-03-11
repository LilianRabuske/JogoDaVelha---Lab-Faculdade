import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //CRIAÇÃO DOS JOGADORES//
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do primeiro jogador: ");
        jogador jogadorOne = new jogador(scanner.nextLine());
        System.out.print("Nome do segundo jogador: ");
        jogador jogadorTwo = new jogador(scanner.nextLine());

        //CRIAÇÃO TABULEIRO//
        int boardSize = 0;

        //TRATANDO EXCECAO CASO ENTRADA NAO FOR INTEIRO
        do {
            try {
                System.out.print("Informe o tamanho do tabuleiro: ");
                boardSize = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido");
            }
            if (boardSize < 3) {
                System.out.println("Valor deve ser maior que 2");
            }
            scanner.nextLine();
        } while (boardSize < 3);
        //FIM TRATAMENTO DA EXCECAO

        //INICIANDO TABULEIRO
        String continuarJogo = "Sim";
        while (continuarJogo.equalsIgnoreCase("Sim")) {
            System.out.println("Criando tabuleiro... ");
            jogoDaVelha jogo = new jogoDaVelha(boardSize);

            //VARIÁVEIS AUXILIARES
            int numeroJogada = 0;
            boolean jogadaRealizada = false;
            boolean vencedor = false;
            boolean empatePartida = false;
            int row = -1;
            int column = -1;
            double numeroPosicoes = Math.pow(jogo.getTabuleiro().length, 2);


            System.out.println("Iniciando nova partida");

            //INICIANDO JOGO
            while (!vencedor || empatePartida) {
                //REALIZANDO JOGADA
                do {
                    //TRATAMENTO DE EXCECAO CASO VALOR INVALIDO OU MAIOR QUE TAMANHO DA MATRIZ
                    do {
                        try {
                            System.out.println(jogadorOne.getNome() + " informe a posição em que deseja jogar. Lembrando que a numeração abrange do número 0 até o número " + (jogo.getTabuleiro().length - 1));
                            System.out.print("Linha: ");
                            row = scanner.nextInt();
                            System.out.print("Coluna: ");
                            column = scanner.nextInt();
                            scanner.nextLine();

                            jogadaRealizada = jogo.realizarJogada(row, column, 'X');
                            if (!jogadaRealizada) {
                                System.out.println("Jogada inválida, tente novamente");
                            } else {
                                numeroJogada++;
                            }
                        } catch (ArrayIndexOutOfBoundsException I) {
                            System.out.println("Posição escolhida não existe.");
                        } catch (InputMismatchException e) {
                            System.out.println("Valor inválido.");
                            scanner.nextLine();
                        }

                    } while (row < 0 || row > (boardSize - 1) || column < 0 || column > (boardSize - 1));
                    //FIM TRATAMNETO DE EXCECOES
                } while (!jogadaRealizada);

                //VERIFICAR RESULTADO JOGADOR 1
                vencedor = jogo.verificaGanhador('X');
                System.out.println(jogo.toString());
                if (vencedor) {
                    jogadorOne.setPontos(jogadorOne.getPontos() + 1);
                    System.out.println("Vencedor da Rodada: " + jogadorOne.toString());
                    break;

                }
                //VERIFICAR SE JOGADOR 1 FEZ A ÚLTIMA JOGADA POSSIVEL
                if (numeroJogada == numeroPosicoes) {
                    empatePartida = true;
                    System.out.println("Partida empatada!");
                    break;
                }

                //REALIZANDO JOGADA
                do {
                    //TRATAMENTO DE EXCECAO CASO VALOR INVALIDO OU MAIOR QUE TAMANHO DA MATRIZ
                    do {
                        try {
                            System.out.println(jogadorTwo.getNome() + " informe a posição em que deseja jogar. Lembrando que a numeração abrange do número 0 até o número  " + (jogo.getTabuleiro().length - 1));
                            System.out.print("Linha: ");
                            row = -1;
                            column = -1;
                            row = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Coluna: ");
                            column = scanner.nextInt();
                            scanner.nextLine();
                            jogadaRealizada = jogo.realizarJogada(row, column, 'O');
                            if (!jogadaRealizada) {
                                System.out.println("Jogada inválida, tente novamente");
                            } else {
                                numeroJogada++;
                            }
                        } catch (ArrayIndexOutOfBoundsException I) {
                            System.out.println("Posição escolhida não existe.");
                        } catch (InputMismatchException e) {
                            System.out.println("Valor inválido.");
                            scanner.nextLine();
                        }
                    } while (row < 0 || row > (boardSize - 1) || column < 0 || column > (boardSize - 1));
                    //FIM TRATAMNETO DE EXCECOES
                } while (!jogadaRealizada);

                //VERIFICAR RESULTADO JOGADOR 2
                vencedor = jogo.verificaGanhador('O');
                System.out.println(jogo.toString());
                if (vencedor) {
                    jogadorTwo.setPontos(jogadorTwo.getPontos() + 1);
                    System.out.println("Vencedor da Rodada: " + jogadorTwo.toString());
                }

                //VERIFICAR SE JOGADOR 2 FEZ A ÚLTIMA JOGADA POSSIVEL
                if (numeroJogada == numeroPosicoes) {
                    empatePartida = true;
                    System.out.println("Partida empatada!");
                    break;
                }
            }
            //FIM DA PARTIDA

            //PERGUNTAR SE DESEJA CONTINUAR JOGANDO
            do {
                System.out.println("Desejam continuar jogando?");
                continuarJogo = scanner.nextLine();
                if(!continuarJogo.equalsIgnoreCase("Sim") && !continuarJogo.equalsIgnoreCase("Nao")){
                    System.out.println("Resposta inválida! Responda apenas com sim ou nao.");
                }
            }while(!continuarJogo.equalsIgnoreCase("Sim") && !continuarJogo.equalsIgnoreCase("Nao"));
            if (continuarJogo.equalsIgnoreCase("Sim")) {
                vencedor = false;
            }


        }
        //FIM DO JOGO

        //VERIFICA QUEM VENCEU O JOGO
        if (jogadorOne.getPontos() == jogadorTwo.getPontos()) {
            System.out.println("EMPATE");
        } else if (jogadorOne.getPontos() > jogadorTwo.getPontos()) {
            System.out.println("Vencedor: " + jogadorOne.toString());
        } else {
            System.out.println("Vencedor: " + jogadorTwo.toString());
        }


    }
}
