package app.android.kingdomanimalia;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.android.kingdomanimalia.models.Quiz;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    private Realm realm;
    private SessionHandler sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();
        sh = new SessionHandler(this);

        if(sh.isFirstTime()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        } else {
            //tambah quiz
            tambahQuiz("Dunia hewan (Animalia) memiliki persamaan cirri dengan dunia jamur (Fungi) dalam hal berikut ini, kecuali ….","Eukariot","Heterotrof","multiseluler","Tidak memiliki klorofil","Tidak memiliki klorofil","E","");
            tambahQuiz("Penyakit Filariasis adalah penyakit yang disebabkan oleh ....","Wucheria bancrofti","Trichinella spiralis","Taenia saginata","Taenia solium","Fasciola hepatica","A","");
            tambahQuiz("Ubur-ubur atau Aurelia merupakan binatang laut yang termasuk dalam golongan ....","Echinodermata","Mollusca","Porifera","Coelenterata","Protozoa","D","");
            tambahQuiz("Cacing palolo yang dapat dimakan termasuk dalam kelas....","Polychaeta","Treamatoda","Oligochaeta","Turbellaria","Cestoda","A","");
            tambahQuiz("Spongia yang dapat digunakan sebagai spons mandi tergolong dalam kelas ....","Hexactinellida","Hylospongiae","Demospongiae","Calcarea","Calcispongiae","C","");
            tambahQuiz("Salah satu contoh porifera yang rangkanya tersusun dari silika adalah ....","Sycon","Leucosolenia","Spongia","Hipospongia","Euplectella","E","");
            tambahQuiz("Amoebosit pada porifera berfungsi untuk ....","Pelindung","Saluran air","Mengedarkan sari makanan","Penopang tubuh","Menangkap makanan dari spongosol","C","");
            tambahQuiz("Kelas calcarea mempunyai spikula berupa ....","SiO2","Serabut spongin","Spons tanpa spikula","CaCO3","Spons dengan spikula","D","");
            tambahQuiz("Klasifikasi porifera menajdi tiga klas, yaitu Hexactinlleda, Demospongiae, dan Calcarea adalah berdasarkan ....","Tipe saluran air","Jenis habitat","Jenis mangsa","Cara reproduksi","Bahan penyusun rangka","A","");
            tambahQuiz("Knidoblast pada coelenterata terdapat pada bagian ....","Epidermis","Endodermos","Gastrodemis","Mesoglea","Gastrovaskuler","B","");
            tambahQuiz("Coelenterata memiliki ciri-ciri berikut, kecuali ….","Eumetazoa","Diploblastik","Berbentuk polip dan / medusa","Memiliki gastrosol","Hidup secara autotrof","E","");
            tambahQuiz("Dibawah ini fase dari Obelia:\n\n1.Medusa\n2.Polip\n3.Planula\n4.Zigot\nUrutan daur hidup obelia adalah....","1, 2, 3 dan 4","1, 3, 4 dan 2","2, 1, 3 dan 4","2, 4, 3, dan 1","3, 4, 2, dan 1","C","");
            tambahQuiz("Coelenterata melumpuhkan mangsa atau musuhnya dengan sel penyengat yang terdapat pada ....","Gastrosol","Tentakel","Mesoglea","Kerangka","Mulut","B","");
            tambahQuiz("Coelenterata yang dapat menghasilkan kerangka luar dengan membentuk karang tergolong dalam kelas ....","Hydrozoa","Scypozoa","Anthozoa","Cnidaria","Obelia","C","");
            tambahQuiz("Manfaat coelenterata dalam ekosistem adalah ....","Melindungi pantai dan erosi","Sebagai bahan penggosok","Menunjukkan tempat minyak bumi","Sebagai bahan isolator dinamit","Sebagai bahan makan","A","");
            tambahQuiz("Holometabola atau metamorfosis sempurna melalui tahap-tahap ....","Telur, larva, imago, pupa","Telur, larva, imago, pupa","Telur, larva, pupa, imago","Telur, imago, nimfa","Telur, imago, pupa, larva","C","");
            tambahQuiz("Lapisan luar tubuh porifera tersusun atas sel . . .","Amoebosit","Pinakosit","Koanosit","Skleroblas","Amoeboid","B","");
            tambahQuiz("Platyhelminthes tidak memiliki sistem pembuluh darah. Bagaimana cara mengedarkan makanan keseluruh tubuhnya?","Dengan menggunakan sistem gastrovaskuler","Dengan menggunakan triplobastik","Dengan menggunakan sistem limfa","Dengan menggunakan mesoderm","Dengan gerakan otot-otot","B","");
            tambahQuiz("Yang merupakan siklus metagenesis Aurelia aurita yang tepat dibawah ini adalah ....","zigot – skifistoma – strobila – efira – medusa – zigot","polip – zigot – skifistoma – strobila – efira – medusa – zigot","zigot – planula – skifistoma – strobila – efira – medusa – zigot","polip – planula – skifistoma – strobila – efira – medusa – zigot","planula – skifistoma – strobila – efira – medusa – zigot","C","");


//pindah level
            tambahQuiz("Anak-anak banyak yang mengalami infeksi cacing perut (Ascaris lumbricoides) karena penularan cacing ini adalah dengan cara ....","Menembus pori-pori kulit","Menembus pori-pori kulit","Menembus pori-pori kulit","Terbawa infeksi dari ibunya sejak lahir","Terinfeksi melalui gigitan nyamuk","B","");
            tambahQuiz("Bintang laut (Asteroidea) bernapas melalui ....","Sistem ambulakral dan papula","Insang trakea","Paru-paru buku","Insang trakea dan paru-paru buku","Insang trakea dan paru-paru buku","A","");
            tambahQuiz("Seorang anak kecil sering manggaruk anusnya karena gatal dan oleh dokter diidentifikasi karena ada infeksi cacing. Cacing yang menginfeksi anak tersebut adalah ....","Ascaris lumbricoides","Ascaris lumbricoides","Oxiyuris vermicularis","Wuchereria bancrofti","Ancylastomo duodeanale","C","");
            tambahQuiz("Bagian ... merupakan kepala cacing pita.","Faring","Proglotid","Skoleks","Radula","Stilet","C","");
            tambahQuiz("hewan hermafrodit, artinya ....","Organ kelamin jantan dan betina dalam satu tubuh","Organ kelamin jantan dan betina terpisah","Fertilisasi diluar tubuh","Fertilisasi didalam tubuh","Menghasilkan keturunan tanpa fertilisasi","A","");
            tambahQuiz("Kerang sering digolongkan kedalam kelompok yang diberi nama yang berbeda karena menggunakan dasar ciri yang berbeda. Berikut ini adalah hubungan yang benar antara nama dan cirinya ....","Pelecypoda, karena kakinya berbentuk pipih","Bivalva, karena insangnya dua","Lamellibranchiata, karena insangnya pipih","Pelecypoda, karena kakinya berlapis-lapis.","Bivalvia, karena kakinya sepasang","A","");
            tambahQuiz("Benang untuk membuat jaring laba-laba berasal dari ....","Trakea","Spineret","Pedipalpus","Paru-paru buku","Kelisera","B","");
            tambahQuiz("Tipe mulut lalat rumah adalah....","Menjilat","Menusuk dan menghisap","Menggigit","Mengisap","Menggigit dan mengunyah","A","");
            tambahQuiz("Insecta yang mengalami metamorfosis sempurna antara lain ....","Belalang (Valanga sp)","Jangkrik (Gryllus sp)","Wereng (Nelaporvata)","Lebah madu (Apis mellifora)","Lalat buah (Drosophila melanogaster)","A","");
            tambahQuiz("Echinodermata yang tubuhnya tidak memiliki lengan adalah....","Holothuroidea dan asteroidea","Aseroidea dan crinoidea","Echinoida dan holothuroidea","Asteroidea dan ophiuroidea","Ophiuroidea dan echinoidea","D","");
            tambahQuiz("Cacing Annelida yang memiliki ciri berbentuk pipih, memiliki alat hisap di kedua ujung tubuhnya dan tidak memiliki chaeta serta parapodia, termasuk ke dalam kelas ....","Polychaeta","Oligochaeta","Hirudinea","Cestoda","Trematoda","C","");
            tambahQuiz("Filum berikut yang semua anggotanya bersifat triploblastik dan memiliki rongga tubuh yang sebenarnya adalah ….","Filum porifera","Filum annelida","Filum coelenterata","Filum paltyhelminthes","Filum nemathelminathes","A","");
            tambahQuiz("Cacing gelang yang bersifat parasit di usus kuda adalah...","Ascaris lumbricoides","Ascaris megalocephala","Ascaris suillae","Ancylostoma duodenale","Oxyuris vermicularis","B","");
            tambahQuiz("Cacing gilik yang menyerang akar tanaman...","Ascaris suillae","Ancylostoma duodenale","Wuchereria bancrofti","Heterodera radicicola","Oxyuris vermicularis","C","");
            tambahQuiz("Untuk membedakan hewan invertebrata, perlu diperhatikan hal-hal berikut, kecuali ....","rangka luar","simetri tubuh","segmentasi tubuh","warna eksoskeleton","tentakel dan antena","D","");
            tambahQuiz("Contoh Insecta yang mengalami metamorphosis sempurna adalah ....","capung","belalang","kutu buku","kecoa","lalat","E","");
            tambahQuiz("Pada lebah, telur yang tidak dibuahi dapat tumbuh menjadi individu baru. Hal ini disebut ....","partenogenesis","metamorfosis","morfogenesis","ametabola","ekdisis","A","");
            tambahQuiz("Nama ilmiah untuk harimau adalah Felis tigris dan singa adalah Felis leo. Dari nama ilmiahnya kita dapat mengetahui bahwa harimau dan singa termasuk dalam satu ....","spesies","habitat","populasi","genus","varian","D","");

            sh.createFirstTimeSession();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
        }
    }

    private void tambahQuiz(String soal,String jawab_a,String jawab_b,String jawab_c, String jawab_d, String jawab_e, String jawab_benar,String pembahasan){
        realm.beginTransaction();

        Quiz quiz = realm.createObject(Quiz.class);

        //increment index
        int nextID  = (int)  (realm.where(Quiz.class).maximumInt("id") + 1);
        quiz.setId(nextID);
        quiz.setSoal(soal);
        quiz.setJawab_a(jawab_a);
        quiz.setJawab_b(jawab_b);
        quiz.setJawab_c(jawab_c);
        quiz.setJawab_d(jawab_d);
        quiz.setJawab_e(jawab_e);
        quiz.setJawab_benar(jawab_benar);
        quiz.setPembahasan(pembahasan);

        realm.commitTransaction();
    }
}
