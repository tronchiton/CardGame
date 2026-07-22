package BoardGame.Tags;

public class Effect {
    public Tag Trigger;

    public enum Target{
        AnyPlayer,
        You,
        Opponent,
        Battle,
    }
    public Target Target;

    public enum effect{
        Defense,
        Attack,
    }

    public effect effect;

    public int number;

    public Effect(Tag Trigger, Target Target, effect effect, int number ){
        this.Trigger=Trigger;
        this.Target=Target;
        this.effect=effect;
        this.number=number;
    }
    public Effect(String Trigger, Target Target, effect effect, int number ){
        this.Trigger=new Tag(Trigger);
        this.Target=Target;
        this.effect=effect;
        this.number=number;
    }

}
