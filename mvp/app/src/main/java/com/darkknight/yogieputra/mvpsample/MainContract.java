package com.darkknight.yogieputra.mvpsample;

public interface MainContract {

    interface MainView {
        void showProgress();
        void hideProgress();
        void setQuote(String string);
    }

    interface GetQuoteInteractor {
        interface OnFinishedListener {
            void onFinished(String string);
        }
        void getNextQuote(OnFinishedListener onFinishedListener);
    }

    interface Presenter {
        void onButtonClicked();
        void onDestroy();
    }

}
