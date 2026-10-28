package demo.mixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(demo.Target.class)
public class KeepFirst {
    @Inject(method = "value()I", at = @At("HEAD"), cancellable = true, require = 1)
    private void inject(CallbackInfoReturnable<Integer> callback) { callback.setReturnValue(42); }
}
