package com.yuzhihao.myplatform.bot.core.pojo;

/**
 * 对话状态信息
 */
public class Session {
    private Long id;
    private DialogContext dialogContext;

    public Session(){
        //生成唯一id TODO

        dialogContext = new DialogContext();
    }

    public DialogContext getDialogContext() {
        return dialogContext;
    }

    public void setDialogContext(DialogContext dialogContext) {
        this.dialogContext = dialogContext;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
