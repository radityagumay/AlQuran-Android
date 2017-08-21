package android.alquran.radityalabs.net.alquran

import android.alquran.radityalabs.net.alquran.data.network.response.BaseResponse
import android.alquran.radityalabs.net.alquran.data.network.response.SurahData
import android.alquran.radityalabs.net.alquran.data.network.response.SurahResponse
import android.alquran.radityalabs.net.alquran.domain.SurahRepository
import android.alquran.radityalabs.net.alquran.presentation.presenter.SurahPresenter
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

import com.nhaarman.mockito_kotlin.*

class SurahPresenterTest {
    val repository: SurahRepository = mock()
    val view: SurahPresenter.View = mock()
    lateinit var presenter: SurahPresenter

    @Before
    fun setup() {
        presenter = SurahPresenter(repository)
    }

    @Test
    fun ShouldCallOnLoadSurah() {
        val list = listOf(SurahData(number = 11, name = "سورة هود", englishName = "Hud", numberOfAyahs = 123, englishNameTranslation = "Hud", revelationType = "Meccan"))
        whenever(repository.onLoadSurah())
                .thenReturn(Single.just(SurahResponse(BaseResponse(200, "success"), list)))
        presenter.attachView(view)
        presenter.onLoadSurah()
        verify(repository).onLoadSurah()
        verify(view).onLoadSurahSuccess(list)
    }
}