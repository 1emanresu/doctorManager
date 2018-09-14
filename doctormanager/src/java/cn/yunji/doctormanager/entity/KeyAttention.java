package cn.yunji.doctormanager.entity;

public class KeyAttention {
    private Integer kid;

    private String attentionproject;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getAttentionproject() {
        return attentionproject;
    }

    public void setAttentionproject(String attentionproject) {
        this.attentionproject = attentionproject == null ? null : attentionproject.trim();
    }

}