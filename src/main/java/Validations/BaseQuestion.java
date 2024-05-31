package Validations;

import Config.CustomActions;

public class BaseQuestion {

    private CustomActions customActions;

    public BaseQuestion(CustomActions customActions) {
        this.customActions = customActions;
    }

    public CustomActions getCustomActions() { return customActions; }

    public void setCustomActions(CustomActions customActions) { this.customActions = customActions; }
}
