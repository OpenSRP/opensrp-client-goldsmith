package org.smartregister.goldsmith.presenter;

import org.smartregister.chw.core.contract.FamilyOtherMemberProfileExtendedContract;
import org.smartregister.chw.core.interactor.CoreFamilyProfileInteractor;
import org.smartregister.chw.core.presenter.CoreFamilyOtherMemberActivityPresenter;
import org.smartregister.family.contract.FamilyOtherMemberContract;
import org.smartregister.family.contract.FamilyProfileContract;
import org.smartregister.goldsmith.interactor.FamilyInteractor;
import org.smartregister.goldsmith.interactor.FamilyProfileInteractor;
import org.smartregister.goldsmith.model.FamilyProfileModel;

public class FamilyOtherMemberActivityPresenter extends CoreFamilyOtherMemberActivityPresenter {
    public FamilyOtherMemberActivityPresenter(FamilyOtherMemberProfileExtendedContract.View view, FamilyOtherMemberContract.Model model, String viewConfigurationIdentifier, String familyBaseEntityId, String baseEntityId, String familyHead, String primaryCaregiver, String villageTown, String familyName) {
        super(view, model, viewConfigurationIdentifier, familyBaseEntityId, baseEntityId, familyHead, primaryCaregiver, villageTown, familyName);
    }

    @Override
    protected CoreFamilyProfileInteractor getFamilyProfileInteractor() {
        if (profileInteractor == null) {
            this.profileInteractor = new FamilyProfileInteractor();
        }
        return (CoreFamilyProfileInteractor) profileInteractor;
    }

    @Override
    protected FamilyProfileContract.Model getFamilyProfileModel(String familyName) {
        if (profileModel == null) {
            this.profileModel = new FamilyProfileModel(familyName);
        }
        return profileModel;
    }

    @Override
    protected void setProfileInteractor() {
        if (familyInteractor == null) {
            familyInteractor = new FamilyInteractor();
        }
    }
}
