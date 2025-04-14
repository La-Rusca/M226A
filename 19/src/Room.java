public class Room {
    private String nome;
    private float superficie;

    public Room(String nome, float superficie) {
        if (superficie <= 0) {
            throw new IllegalArgumentException("inserire un numero positivo");
        }
        this.nome = nome;
        this.superficie = superficie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    @Override
    public String toString() {
        return "Room= " + "Nome: '" + nome + '\'' + ", Superficie: " + superficie;
    }
}

