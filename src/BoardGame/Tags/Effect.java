package BoardGame.Tags;

public class Effect {
    Tag Trigger;

    public enum Target{
        AnyPlayer,
        You,
        Opponent,
        Battle,
    }
    Target Target;

    public enum effect{
        Defense,
        Attack,
    }

    effect effect;

    int number;

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
