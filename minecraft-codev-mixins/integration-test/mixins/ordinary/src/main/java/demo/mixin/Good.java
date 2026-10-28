package demo.mixin;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.*;
@Mixin(demo.Target.class)
public class Good {
    @Inject(method="value()I",at=@At("HEAD"),cancellable=true,require=1) private void inject(CallbackInfoReturnable<Integer> c){
        c.setReturnValue(42);
    }
}
