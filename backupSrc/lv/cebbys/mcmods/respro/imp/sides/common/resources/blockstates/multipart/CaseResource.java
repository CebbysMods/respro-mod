package lv.cebbys.mcmods.respro.component.resource.blockstates.multipart;

import lv.cebbys.mcmods.respro.component.resource.JsonObjectResource;
import lv.cebbys.mcmods.respro.imp.component.BlockProperty;
import lv.cebbys.mcmods.respro.component.resource.blockstates.variant.VariantResource;
import lv.cebbys.mcmods.respro.mapper.JsonPart;
import net.minecraft.resource.ResourceType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CaseResource extends JsonObjectResource {

    @JsonPart(value = "when")
    protected Map<String, String> when;
    @JsonPart(value = "when/or")
    protected List<Map<String, String>> whenOr;
    @JsonPart(value = "apply")
    protected VariantResource apply;

    public CaseResource when(BlockProperty o) {
        if(when == null && whenOr == null) {
            when = o.toMultipart();
        } else {
//            ResproLogger.fail("Reinitialization is not allowed for " + getClass().getSimpleName() + " when element");
        }
        return this;
    }

    public CaseResource when(List<BlockProperty> o) {
        if(when == null && whenOr == null) {
            whenOr = o.stream().map(BlockProperty::toMultipart).collect(Collectors.toList());
        } else {
//            ResproLogger.fail("Reinitialization is not allowed for " + getClass().getSimpleName() + " when or element");
        }
        return this;
    }

    public CaseResource apply(VariantResource o) {
        if(apply == null) {
            apply = o;
        } else {
//            ResproLogger.fail("Reinitialization is not allowed for " + getClass().getSimpleName() + " apply element");
        }
        return this;
    }

    @Override
    protected boolean belongsTo(ResourceType type) {
        return ResourceType.CLIENT_RESOURCES.equals(type);
    }
}