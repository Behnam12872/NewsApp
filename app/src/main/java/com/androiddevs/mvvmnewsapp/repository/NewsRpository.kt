package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance().api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance().api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article:Article)=db.articleDao().upsert(article)

    fun getSavedNews()=db.articleDao().getAllArticles()

    suspend fun deleteArticle(article: Article)=db.articleDao().deleteArticle(article)



}