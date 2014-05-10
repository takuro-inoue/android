package takinoue.missionstatement.helper;

import java.util.ArrayList;

import takinoue.missionstatement.bean.MissionStatementBean;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DBを操作するためのクラス.
 */
public class DBHelper extends SQLiteOpenHelper {

    /** コンストラクタ */
    public DBHelper(Context context, String dbname, int version) {
        super(context, dbname, null, version);
    }

    public void onCreate(SQLiteDatabase db) {

        // ミッションステートメントテーブル
        String sql = "CREATE TABLE MISSION_STATEMENT(" +
        		"ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CATEGORY_ID INTEGER," +
        		"WORDS TEXT," +
        		"PERSON TEXT," +
        		"REGIST_DATE DEFAULT CURRENT_TIMESTAMP);";
        db.execSQL(sql);

        // カテゴリーテーブル
        sql = "CREATE TABLE CATEGORY(" +
                "CATEGORY_ID INTEGER PRIMARY KEY," +
                "CATEGORY TEXT," +
                "REGIST_DATE DEFAULT CURRENT_TIMESTAMP);";
        db.execSQL(sql);

        // ----- 名言 ----------
        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(1,'ミッションステートメント');";
        db.execSQL(sql);

        sql = "INSERT INTO MISSION_STATEMENT(CATEGORY_ID, WORDS, PERSON)" +
                " SELECT 1,'どんなときでも楽しむことを心がける。', 'ミッションステートメント（基本）'" +
                " UNION ALL" +
                " SELECT 1,'人と接するときは、笑顔とユーモアを忘れないようにする。', 'ミッションステートメント（基本）'" +
                " UNION ALL" +
                " SELECT 1,'嫌な気持ちになったときは、何かが嫌な気持ちにさせているのではなく、自分で嫌な気持ちになることを選んでいることを自覚し、違う感情を持つことを選び直す。', 'ミッションステートメント（仕事）'" +
                " UNION ALL" +
                " SELECT 1,'できるだけ人の良いところを見つけ、本人に伝える。', 'ミッションステートメント（仕事）'" +
                " UNION ALL" +
                " SELECT 1,'うまくいかない状況も、嫌な仕事も楽しむ。\n不満は言わないようにする。', 'ミッションステートメント（仕事）'" +
                " UNION ALL" +
                " SELECT 1,'主体性を発揮し、人に頼らず出来る限り自分で解決する。', 'ミッションステートメント（仕事）'" +
                " UNION ALL" +
                " SELECT 1,'面倒見よく周りに接し、頼りにしてきた人や困ってる人を助ける。', 'ミッションステートメント（仕事）'" +
                ";";
        db.execSQL(sql);

        // ----- 名言 ----------
        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(2,'名言');";
        db.execSQL(sql);

        sql = "INSERT INTO MISSION_STATEMENT(CATEGORY_ID, WORDS, PERSON)" +
        		" SELECT 2,'最も重要なことから始めよ。', 'ピーター・ドラッカー'" +
        		" UNION ALL" +
        		" SELECT 2,'信頼してこそ人は尽くしてくれるものだ。','武田信玄'" +
                ";";
        db.execSQL(sql);

        // ----- 「７つの習慣」スティーブ・R・コヴィー ----------
        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(3,'「７つの習慣」スティーブ・R・コヴィー');";
        db.execSQL(sql);

        sql = "INSERT INTO MISSION_STATEMENT(CATEGORY_ID, WORDS, PERSON)" +
                " SELECT 3,'大きな変化を望むならパラダイムシフトが必要だ。パラダイムとは物事の見方である。\nものごとの見方が世界観を作り、全ての行動を方向づける。', 'スティーブ・R・コヴィー'" +
                " UNION ALL" +
                " SELECT 3,'問題を解決するには問題についてのパラダイムを正しくしないといけない。\n「人が言うことを聞いてくれない」とき、その人に対する見方に問題はないか？物や道具のように見ていないだろうか？', 'スティーブ・R・コヴィー'" +
                " UNION ALL" +
                " SELECT 3,'問題の解決にはインサイド・アウトのアプローチが大事である。\nインサイド・アウトのアプローチとは、自分の内面から変えることであり、パラダイム、人格、動機を変えることから始めることである。\n仕事でもっと裁量が欲しければ、より重い責任を引き受け、力を尽くして貢献できる人財になることである。\n信頼されたければ、信頼性のある人間になることである。\n子供が明るく協調性のある人間に育って欲しければ、子供の視点に立ち、理解を深め、愛を示す親になることである。\n才能が認められると言う二次的な成功が欲しければ、まず人格と能力を向上させるという一時的な成功に焦点を合わせることである。', 'スティーブ・R・コヴィー'" +
                " UNION ALL" +
                " SELECT 3,'自分自信を改善せずに、人との関係は改善できない。\n不幸な人間関係は、相手が変わることを要求する。', 'スティーブ・R・コヴィー'" +
                " UNION ALL" +
                " SELECT 3,'思いの種を撒いて行動を刈り取り、行動の種を撒いて習慣を刈り取り、習慣の種を撒いて人格を刈り取り、人格の種を撒いて人生を刈り取る。', 'スティーブ・R・コヴィー'" +
                " UNION ALL" +
                " SELECT 3,'人間には「依存」「自立」「相互依存」の３段階の状態があり、７つの習慣によって成長する。\n依存のパラダイムは「誰かが私を助けてくれる。誰かが結果を出してくれる。うまくいかないのは誰かのせいだ。」\n自立のパラダイムは「私がやる。私の責任だ。私は選択できる。」\n相互依存のパラダイムは「私達はできる。私達は協力する。私達が力を出し合えば、もっと素晴らしい結果を生み出せる。」\n依存してる人は他人に頼らないといけない。\n自立してる人は自分の力で結果を出せる。\n相互依存してる人は自分と他人の力を合わせて最大の結果を出せる。', 'スティーブ・R・コヴィー'" +
                " UNION ALL" +
                " SELECT 3,'自立していても相互依存に考えれない人は、独立した生産者としては好成績を上げれても、チームの良いメンバーやリーダーになることはできない。', 'スティーブ・R・コヴィー'" +
                ";";
        db.execSQL(sql);

        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(4,'「７つの習慣」第一の習慣　スティーブ・R・コヴィー');";
        db.execSQL(sql);

        sql = "INSERT INTO MISSION_STATEMENT(CATEGORY_ID, WORDS, PERSON)" +
                " SELECT 4,'第一の習慣\n主体性を発揮する', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'人間は刺激と反応の間に選択の自由を持っている。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'主体性を発揮するとは、自分の人生に対する責任をとるということである。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'私たちの行動は周りの状況からだけでなく、私たち自身の選択によって決まるのだ。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'反応的な人は環境に影響される。人に親切にされれば気分がいいが、そうでないと落ち込んだり不機嫌になったりする。反応的な人は他人に左右されて振り回される。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'心底から正直に「今の状況はこれまで自分が行ってきた選択の結果だ」と言えるようになるまで、「他の道を選ぶ」ということはできない。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'自分の身に何が起こるかではなく、それにどう反応するかが重要なのだ。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'外的な要因で肉体的や経済的に害を受けることもある。しかし、人格、基礎的なアイデンティティまでが害される必要はない。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'辛い経験でこそ人格が形成される。\nそれによって厳しい状況に対応する能力が高まり、人に模範を示し感動と励ましを与える人間になれる。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'実行力を発揮する。周りがやるのを待っていれば周りに左右される。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'反応的な人は、他人の欠点、周りの環境、自分がコントロールできない、影響できないことに集中する。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'自分が直接コントロールできる、または大きく影響できることに集中すると、影響できることが広がる。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'「できない」「しないといけない」「～さえあれば」といった言葉は使わない。否定的な言葉は自己達成予言になる。\n「～を選ぶ」「～をする」といった主体的な言葉を使う。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'問題が自分の外にあると考えては何も解決しない。変えられるのは自分の中だけである。自分を変えることで問題を解決させる。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'自分に指示する人間を感情的に批判しない。その人が何を望んでいるのか理解することに努め、期待以上の成果を出す方法を主体的に考える。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'他の人が問題を解決してくれるのを待たない。主体的に問題解決に貢献する。\n頭と率先力を発揮する。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'状況を改善したいのなら、コントロールできる唯一のもの－自分自身－に働きかけるべきである。どういう自分になればいいのか考える。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'関心の輪ではなく、影響の輪に集中する。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'影響の和の最も中心にあるものは、約束を守ることである。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'裁く人ではなく、光を与える人になる。\n批判者ではなく、模範者になる。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'他人のせいにしたり、他人を批判する無駄なエネルギーを使わない。\n自分自身を変えるようにし、自分の在り方に注目する。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'他人の弱点や欠点を批判する目ではなく、慈しみ深い目で見る。\n彼らが何をしているのか、何を怠っているかが問題ではなく、それに対して自分がどういう反応を選択するか、自分が何をするかが問題なのだ。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'回りの人間の声を聞いてみる。\n「○○でさえあったら」「できない」「しなくてはならない」といった反応的な言葉をどれだけ聞くことになるか。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'次に反応的になってしまいそうなイベントを思い浮かべる。\nどのような主体的な反応ができるどろうか。\n主体的に反応している自分を想像してみる。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'今抱えている問題を１つ思い浮かべる。\nその問題は、直接的にコントロールできる問題、間接的にコントロールできる問題、全くコントロールできない問題のどれだろうか。\nその問題を解決するために、影響の輪の中でとれる具体的な行動を考え、実施する。', '「７つの習慣」第一の習慣'" +
                " UNION ALL" +
                " SELECT 4,'帰り道で、主体的にできたこと、反応的になってしまったことを振り返る。', '「７つの習慣」第一の習慣'" +
                ";";
        db.execSQL(sql);

        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(5,'「７つの習慣」第二の習慣　スティーブ・R・コヴィー');";
        db.execSQL(sql);

        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(6,'「７つの習慣」第三の習慣　スティーブ・R・コヴィー');";
        db.execSQL(sql);

        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(7,'「７つの習慣」第四の習慣　スティーブ・R・コヴィー');";
        db.execSQL(sql);

        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(8,'「７つの習慣」第五の習慣　スティーブ・R・コヴィー');";
        db.execSQL(sql);

        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(9,'「７つの習慣」第六の習慣　スティーブ・R・コヴィー');";
        db.execSQL(sql);

        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(10,'「７つの習慣」第七の習慣　スティーブ・R・コヴィー');";
        db.execSQL(sql);

        // ----- 仕事 ----------
        sql = "INSERT INTO CATEGORY(CATEGORY_ID, CATEGORY) VALUES(11,'仕事');";
        db.execSQL(sql);

        sql = "INSERT INTO MISSION_STATEMENT(CATEGORY_ID, WORDS, PERSON)" +
                " SELECT 11,'自分自身が好きなもの、感銘を受けたサービス、驚いたビジネスモデルなどがあれば、「その本質は何か？」を考え、表面的なものを取り除いて根っこにあるエッセンスや価値観などを取り出して、自分なりに味付けしていけばよいのです。', '仕事'" +
                ";";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 指定されたカテゴリを全件取得
     * @return
     */
    public ArrayList<MissionStatementBean> getMissionStatementAtCategory(int category) {

        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT ID, CATEGORY_ID, WORDS, PERSON, REGIST_DATE FROM MISSION_STATEMENT WHERE CATEGORY_ID = " + category + " ORDER BY ID";
        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<MissionStatementBean> missionStatementBeanList = new ArrayList<MissionStatementBean>();

        // 取得できた場合
        while(cursor.moveToNext()) {

            MissionStatementBean missionStatementBean = new MissionStatementBean();
            missionStatementBean.setId(cursor.getInt(0));
            missionStatementBean.setCategoryId(cursor.getInt(1));
            missionStatementBean.setWords(cursor.getString(2));
            missionStatementBean.setPerson(cursor.getString(3));
            //missionStatementBean.setRegistDate(registDate);

            missionStatementBeanList.add(missionStatementBean);
        }

        return missionStatementBeanList;
    }

    /**
     * ランダムに一件取得
     * @return
     */
    public MissionStatementBean getMissionStatementRandom() {

        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT ID, CATEGORY_ID, WORDS, PERSON, REGIST_DATE FROM MISSION_STATEMENT ORDER BY RANDOM() LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);

        MissionStatementBean missionStatementBean = new MissionStatementBean();

        // 取得できた場合
        if(cursor.moveToNext()) {
            missionStatementBean.setId(cursor.getInt(0));
            missionStatementBean.setCategoryId(cursor.getInt(1));
            missionStatementBean.setWords(cursor.getString(2));
            missionStatementBean.setPerson(cursor.getString(3));
            //missionStatementBean.setRegistDate(registDate);
        }

        return missionStatementBean;
    }
}
