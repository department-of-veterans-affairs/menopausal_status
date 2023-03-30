package gov.va.vinci.menopause.pipeline;

import gov.va.vinci.leo.descriptors.LeoTypeSystemDescription;
import gov.va.vinci.menopause.TypeSystem;

public class LMPPipeline extends BasePipeline {

    @Override
    protected LeoTypeSystemDescription defineTypeSystem() {
        description = TypeSystem.getLeoTypeSystemDescription();
        return description;
    }
}
