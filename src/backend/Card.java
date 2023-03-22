package backend;

public class Card{
    private int num;
    private int color;
    public static int PLUS_TWO = 10;
    public static int PLUS_FOUR = 11;
    public static int SKIP = 12;
    public static int REVERSE = 13;
    public static int RED = 1;
    public static int GREEN = 2;
    public static int BLUE = 3;
    public static int YELLOW = 4;

    public Card(int num, int color){
        if(num > 0 && num < 14){
            this.num = num;
        }
        if(color > 0 && color < 5){
            this.color = color;
        }
    }

    public int getNum(){
        return this.num;
    }

    public String getColor(){
        if(this.color == Card.RED)
            return "Red";
        else if(this.color == Card.GREEN)
            return "Green";
        else if(this.color == Card.BLUE)
            return "Blue";
        else if(this.color == Card.YELLOW)
            return "Yellow";
        return null;
    }

    public String toString(){
        String ret = this.getColor();
        if(this.num == Card.PLUS_TWO)
            ret += " Plus Two";
        else if(this.num == Card.PLUS_FOUR)
            ret += " Plus Four";
        else if(this.num == Card.SKIP)
            ret += " Skip";
        else if(this.num == Card.REVERSE)
            ret += " Reverse";
        else if (this.num > 0 && this.num < 10)
            ret += " " + this.getNum();
        return ret;
    }
}