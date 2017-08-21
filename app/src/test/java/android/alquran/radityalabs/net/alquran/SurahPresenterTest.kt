package android.alquran.radityalabs.net.alquran

import android.alquran.radityalabs.net.alquran.data.database.RealmHelper
import android.alquran.radityalabs.net.alquran.data.network.RestService
import android.alquran.radityalabs.net.alquran.data.network.response.BaseResponse
import android.alquran.radityalabs.net.alquran.data.network.response.SurahData
import android.alquran.radityalabs.net.alquran.data.network.response.SurahResponse
import android.alquran.radityalabs.net.alquran.domain.SurahUseCase
import android.alquran.radityalabs.net.alquran.presentation.presenter.SurahPresenter
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

import com.nhaarman.mockito_kotlin.*

class SurahPresenterTest {
    val view: SurahPresenter.View = mock()
    val service: RestService = mock()
    val realm: RealmHelper = mock()

    private lateinit var usecase: SurahUseCase
    private lateinit var presenter: SurahPresenter

    @Before
    fun setup() {
        usecase = SurahUseCase(service, realm)
        presenter = SurahPresenter(usecase)
    }

    @Test
    fun shoudLoadSurah() {
        val list = listOf(SurahData(number = 11, name = "سورة هود", englishName = "Hud", numberOfAyahs = 123, englishNameTranslation = "Hud", revelationType = "Meccan"))
        whenever(usecase.onLoadSurah())
                .thenReturn(Single.just(SurahResponse(BaseResponse(200, "success"), list)))
        presenter.onLoadSurah()
        verify(view, never()).showError(any<String>())
    }
}