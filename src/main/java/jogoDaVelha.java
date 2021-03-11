import java.util.Arrays;
import java.text.MessageFormat;

public class jogoDaVelha {
    private char tabuleiro[][];


    public jogoDaVelha(int boardSize) {
        this.tabuleiro = new char[boardSize][boardSize];
    }

    public boolean realizarJogada(int row, int column, char symbol) {
        boolean validaJogada = false;
        if (tabuleiro[row][column] != 'X' && tabuleiro[row][column] != 'O') {
            tabuleiro[row][column] = symbol;
            validaJogada = true;
        }
        return validaJogada;
    }


    public boolean verificaGanhador(char symbol) {
        boolean existeGanhador = false;
        int posicaoMarcada = 0;
        //VERIFICA DIAGONAL direita -> esquerda
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][i] == symbol) {
                posicaoMarcada++;
            }

        }
        if (posicaoMarcada == tabuleiro.length) {
            existeGanhador = true;
            return existeGanhador;
        } else {
            posicaoMarcada = 0;
        }


        //VERIFICA DIAGONAL esquerda -> direita
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][tabuleiro.length - (i + 1)] == symbol) {
                posicaoMarcada++;
            }

        }
        if (posicaoMarcada == tabuleiro.length) {
            existeGanhador = true;
            return existeGanhador;
        } else {
            posicaoMarcada = 0;
        }


        //VERIFICA LINHA
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j] == symbol) {
                    posicaoMarcada++;
                }
            }
            if (posicaoMarcada == tabuleiro.length) {
                existeGanhador = true;
                return existeGanhador;
            } else {
                posicaoMarcada = 0;
            }
        }


        //VERIFICA COLUNA
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[j][i] == symbol) {
                    posicaoMarcada++;
                }
            }
            if (posicaoMarcada == tabuleiro.length) {
                existeGanhador = true;
                return existeGanhador;
            } else {
                posicaoMarcada = 0;
            }
        }


        return existeGanhador;

    }
    @Override
    public String toString() {
        String situacaoTabuleiro = "";
        for (int i = 0; i < this.tabuleiro.length; i++) {
            situacaoTabuleiro += "\n" + "| ";
            for (int j = 0; j < this.tabuleiro.length; j++) {
                String representacaoTabuleiro = tabuleiro[i][j] != 'X' && tabuleiro[i][j] != 'O' ? " " : String.valueOf(tabuleiro[i][j]);
                situacaoTabuleiro += representacaoTabuleiro + " | ";

            }
        }
        return situacaoTabuleiro;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }
}
