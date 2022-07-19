package lv.cebbys.mcmods.respro.component.resource.blockstates.multipart;

import lv.cebbys.mcmods.respro.mapper.JsonPart;
import lv.cebbys.mcmods.respro.component.resource.blockstates.BlockStateResource;
import lv.cebbys.mcmods.respro.component.resource.blockstates.variant.VariantResource;
import lv.cebbys.mcmods.respro.imp.component.BlockProperty;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class MultipartStateResource extends BlockStateResource {
    @JsonPart(value = "multipart")
    protected final List<CaseResource> multipart = new LinkedList<>();

    public void apply(Consumer<VariantResource> consumer) {
        CaseResource resource = new CaseResource();
        VariantResource variant = new VariantResource();
        consumer.accept(variant);
        resource.apply(variant);
        multipart.add(resource);
    }

    public WhenCase when(BlockProperty p0) {
        CaseResource resource = new CaseResource();
        multipart.add(resource);
        return new WhenCase(resource, p0);
    }
}