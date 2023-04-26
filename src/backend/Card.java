package backend;

public class Card{
    private int num;
    private int color;
    public static final int PLUS_TWO = 10;
    public static final int PLUS_FOUR = 11;
    public static final int SKIP = 12;
    public static final int WILD = 13;
    public static final int RED = 1;
    public static final int GREEN = 2;
    public static final int BLUE = 3;
    public static final int YELLOW = 4;

    public Card(int num, int color){
        if(num > 0 && num < 14){
            this.num = num;
        }
        if(color > 0 && color < 5){
            this.color = color;
        }
    }

    public Card(){
        this.num = (int) (Math.random() * 13) + 1;
        this.color = (int) (Math.random() * 4) + 1;
    }

    public int getNum(){
        return this.num;
    }

    public int getColor(){
        return this.color;
    }

    public void setColor(int color){
        this.color = color;
    }

    public String getColorString(){
        if(this.color == Card.RED)
            return "red";
        else if(this.color == Card.GREEN)
            return "green";
        else if(this.color == Card.BLUE)
            return "blue";
        else if(this.color == Card.YELLOW)
            return "yellow";
        return null;
    }

    public String toString(){
        String ret = this.getColorString();
        if(this.num == Card.PLUS_TWO)
            return "plustwo_"+this.getColorString();
        else if(this.num == Card.PLUS_FOUR)
            return "plusfour";
        else if(this.num == Card.SKIP)
            return "stop_" + this.getColorString();
        /*else if(this.num == Card.REVERSE)
            ret += " Reverse";*/
        else if(this.num == Card.WILD)
            return "wildcard";
        else if (this.num > 0 && this.num < 10)
            return this.num + "_" + this.getColorString();
        return null;
    }
}