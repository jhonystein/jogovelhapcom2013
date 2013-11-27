package jogovelha2;

public class JogoVelha {
  private String[][] tabuleiro;
  private int jogadas;
  private String jogadorAtual;
  public JogoVelha() {
    tabuleiro = new String[][]{
                    {"","",""},
                    {"","",""},
                    {"","",""}};
    jogadas = 0;
    jogadorAtual = "X";
  }
  public void preencherTabuleiro(int x, int y) {
    if (tabuleiro[x][y].equals("")) {
      tabuleiro[x][y] = jogadorAtual;
      if (!verificarEmpate() && !verificarGanhador()) {
        // trocar jogador autal
        jogadorAtual = jogadorAtual.equals("X") ? "O" : "X";
        jogadas++;
      }
    }
  }
  public String retornarJogadorAtual() {
    return jogadorAtual;
  }
  public boolean verificarEmpate() {
    if (!verificarGanhador() && jogadas >= 9) {
      return true;
    }
    return false;
  }
  public boolean verificarGanhador() {
    // verificar linhas
    for(int linha = 0; linha < tabuleiro.length; linha++) {
      if (!tabuleiro[linha][0].isEmpty() && 
          tabuleiro[linha][0].equals(tabuleiro[linha][1]) &&
          tabuleiro[linha][1].equals(tabuleiro[linha][2])) {
        return true;
      }
    }
    for (int coluna = 0; coluna < tabuleiro.length; coluna++) {
      if (!tabuleiro[0][coluna].isEmpty() && 
          tabuleiro[0][coluna].equals(tabuleiro[1][coluna]) &&
          tabuleiro[1][coluna].equals(tabuleiro[2][coluna])) {
        return true;
      }
    }
    if (!tabuleiro[0][0].isEmpty() &&
        tabuleiro[0][0].equals(tabuleiro[1][1]) &&
        tabuleiro[1][1].equals(tabuleiro[2][2])) {
      return true;
    }
    if (!tabuleiro[0][2].isEmpty() &&
        tabuleiro[0][2].equals(tabuleiro[1][1]) &&
        tabuleiro[1][1].equals(tabuleiro[2][0])) {
      return true;
    }
    return false;
  }
}
