package com.example.postapi.service.impl;

import com.example.postapi.dto.request.GenericPostRequest;
import com.example.postapi.dto.request.UpdatePostRequest;
import com.example.postapi.dto.response.GenericPostResponse;
import com.example.postapi.dto.response.UpdatePostResponse;
import com.example.postapi.entity.Post;
import com.example.postapi.entity.PostCategory;
import com.example.postapi.exception.NotFoundException;
import com.example.postapi.exception.RestException;
import com.example.postapi.repository.PostRepository;
import com.example.postapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    String notFoundText = "Post not found!";



    @Override
    public GenericPostResponse findPostById(Long id) {
        return modelMapper.map(postRepository.findById(id).orElseThrow(() ->
                new NotFoundException(notFoundText)), GenericPostResponse.class);
    }

    @Override
    public Collection<GenericPostResponse> findAll() {
        return postRepository.findAll()
                .stream()
                .map(post -> modelMapper.map(post, GenericPostResponse.class))
                .toList();
    }

    @Override
    public GenericPostResponse createPost(GenericPostRequest postRequest) {
        try {
            var createPost = postRepository.save(modelMapper.map(postRequest, Post.class));
            return modelMapper.map(createPost, GenericPostResponse.class);
        } catch (Exception e) {
            throw new RestException(e.getMessage());
        }
    }

    @Override
    public UpdatePostResponse updatePost(Long id, UpdatePostRequest updatePostRequest) {
        var updatePost = postRepository.findById(id).orElseThrow(() ->
                new NotFoundException(notFoundText));
        modelMapper.map(updatePostRequest, updatePost);
        return modelMapper.map(postRepository.saveAndFlush(updatePost), UpdatePostResponse.class);
    }

    @Override
    public GenericPostResponse deletePost(Long id) {
        var deletePost = postRepository.findById(id).orElseThrow(() ->
                new NotFoundException(notFoundText));
        postRepository.delete(deletePost);
        return modelMapper.map(deletePost, GenericPostResponse.class);

    }

    @Override
    public Collection<GenericPostResponse> findPostsByAuthor(String author) {

        return postRepository.findPostsByAuthor(author)
                .stream()
                .map(postAuthor -> modelMapper.map(postAuthor, GenericPostResponse.class))
                .toList();
    }

    @Override
    public Collection<GenericPostResponse> findPostsByCategory(PostCategory category) {
        return postRepository.findPostsByCategory(category)
                .stream()
                .map(postCategory -> modelMapper.map(postCategory, GenericPostResponse.class))
                .toList();
    }

    @Override
    public Collection<GenericPostResponse> getLastThreePost() {
        return postRepository.findAll()
                .stream()
                .map(post -> modelMapper.map(post, GenericPostResponse.class))
                .sorted(Comparator.comparing(GenericPostResponse::getCreatedAt).reversed())
                .limit(3)
                .toList();

    }
}
