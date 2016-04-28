package app.android.kingdomanimalia.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Unknown on 28/04/2016.
 */
public class Quiz extends RealmObject {
    @PrimaryKey
    private int id;

    private String soal,jawab_a,jawab_b,jawab_c,jawab_d,jawab_e,jawab_benar,pembahasan;

    public Quiz() {
    }

    public Quiz(int id, String soal, String jawab_a, String jawab_b, String jawab_c, String jawab_d,String jawab_e, String jawab_benar, String pembahasan) {
        this.id = id;
        this.soal = soal;
        this.jawab_a = jawab_a;
        this.jawab_b = jawab_b;
        this.jawab_c = jawab_c;
        this.jawab_d = jawab_d;
        this.jawab_e = jawab_e;
        this.jawab_benar = jawab_benar;
        this.pembahasan = pembahasan;
    }

    public Quiz(String soal, String jawab_a, String jawab_b, String jawab_c, String jawab_d, String jawab_e, String jawab_benar,String pembahasan) {
        this.soal = soal;
        this.jawab_a = jawab_a;
        this.jawab_b = jawab_b;
        this.jawab_c = jawab_c;
        this.jawab_d = jawab_d;
        this.jawab_e = jawab_e;
        this.jawab_benar = jawab_benar;
        this.pembahasan = pembahasan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJawab_a() {
        return jawab_a;
    }

    public void setJawab_a(String jawab_a) {
        this.jawab_a = jawab_a;
    }

    public String getJawab_b() {
        return jawab_b;
    }

    public void setJawab_b(String jawab_b) {
        this.jawab_b = jawab_b;
    }

    public String getJawab_c() {
        return jawab_c;
    }

    public void setJawab_c(String jawab_c) {
        this.jawab_c = jawab_c;
    }

    public String getJawab_d() {
        return jawab_d;
    }

    public void setJawab_d(String jawab_d) {
        this.jawab_d = jawab_d;
    }

    public String getJawab_e() {
        return jawab_e;
    }

    public void setJawab_e(String jawab_e) {
        this.jawab_e = jawab_e;
    }

    public String getJawab_benar() {
        return jawab_benar;
    }

    public void setJawab_benar(String jawab_benar) {
        this.jawab_benar = jawab_benar;
    }

    public String getPembahasan() {
        return pembahasan;
    }

    public void setPembahasan(String pembahasan) {
        this.pembahasan = pembahasan;
    }
}
