package android.alquran.radityalabs.net.alquran.presentation.di.module

import android.alquran.radityalabs.net.alquran.BuildConfig
import android.alquran.radityalabs.net.alquran.data.network.ApiConstant
import dagger.Module
import android.alquran.radityalabs.net.alquran.data.network.RestService
import android.alquran.radityalabs.net.alquran.data.network.interceptor.CacheInterceptor
import android.alquran.radityalabs.net.alquran.presentation.di.qualifier.DefaultUrl
import retrofit2.Retrofit
import dagger.Provides
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by radityagumay on 8/12/17.
 */
@Module
class HttpModule {

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
    }

    @Singleton
    @Provides
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    @Singleton
    @Provides
    @DefaultUrl
    fun provideRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit {
        return builder.baseUrl(ApiConstant.BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideCacheInterceptor(): CacheInterceptor {
        return CacheInterceptor()
    }

    @Singleton
    @Provides
    fun provideClient(builder: OkHttpClient.Builder, cacheInterceptor: CacheInterceptor): OkHttpClient {
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        builder.addNetworkInterceptor(cacheInterceptor)
        builder.cache(setupCache())
        builder.connectTimeout(20, TimeUnit.SECONDS)
        builder.readTimeout(20, TimeUnit.SECONDS)
        builder.writeTimeout(20, TimeUnit.SECONDS)
        builder.retryOnConnectionFailure(true)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRestService(@DefaultUrl retrofit: Retrofit): RestService {
        return retrofit.create(RestService::class.java)
    }

    private fun setupCache(): Cache {
        return Cache(File(ApiConstant.PATH_CACHE), 1024 * 1024 * 50)
    }
}
