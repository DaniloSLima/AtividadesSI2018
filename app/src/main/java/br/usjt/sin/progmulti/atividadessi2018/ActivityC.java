package br.usjt.sin.progmulti.atividadessi2018;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.usjt.sin.progmulti.atividadessi2018.util.StatusTracker;
import br.usjt.sin.progmulti.atividadessi2018.util.Utils;

/**Example Activity to demonstrate the lifecycle callback methods.
 * Danilo de Souza Lima RA:816114969
 */
public class ActivityC extends Activity {

    private String mActivityName;
    private TextView mStatusView;
    private TextView mStatusAllView;
    private StatusTracker mStatusTracker = StatusTracker.getInstance();

    /**Método OnCreate é usado para configurar a interface.
     * Danilo de Souza Lima RA:816114969
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        mActivityName = getString(R.string.activity_a);
        mStatusView = (TextView)findViewById(R.id.status_view_a);
        mStatusAllView = (TextView)findViewById(R.id.status_view_all_a);
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    /**O método onStart é executado depois de a Activity ter sido enviada para o segundo plano.
     * Danilo de Souza Lima RA:816114969
     */
    @Override
    protected void onStart() {
        super.onStart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_start));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    /**O método onRestart é chamado depois que atividade tiver sido interrompida, logo antes de ser reiniciada.
     * Danilo de Souza Lima RA:816114969
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    /**O método onResume é acionado quando a Activity se inicia e quando é reiniciada.
     * Danilo de Souza Lima RA:816114969
     */
    @Override
    protected void onResume() {
        super.onResume();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    /**O método onPause é acionado, quando a Activity deixa o primeiro plano.
     * Danilo de Souza Lima RA:816114969
     */
    @Override
    protected void onPause() {
        super.onPause();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    /**O método onStop é chamado quando a Activity não está mais visível para o usuário..
     * Danilo de Souza Lima RA:816114969
     */
    @Override
    protected void onStop() {
        super.onStop();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop));
    }

    /**O método onDestroy é chamado quando a Activity vai ser destruida
     * Danilo de Souza Lima RA:816114969
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy));
        mStatusTracker.clear();
    }

    public void startDialog(View v) {
        Intent intent = new Intent(ActivityC.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityB.class);
        startActivity(intent);
    }

    public void startActivityC(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityC.class);
        startActivity(intent);
    }

    public void finishActivityA(View v) {
        ActivityC.this.finish();
    }
}
